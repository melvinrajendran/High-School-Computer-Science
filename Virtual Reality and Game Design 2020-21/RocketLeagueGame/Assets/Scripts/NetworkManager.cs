using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using Photon.Pun;
using Photon.Realtime;
using TMPro;

public class NetworkManager : MonoBehaviourPunCallbacks
{
    // Instance of NetworkManager
    public static NetworkManager instance;
    public GameObject mainMenu, joinMenu, roomMenu, scrollViewContent, roomButton;
    public TextMeshProUGUI nameText, roomText;
    public TextMeshProUGUI[] playerTextList;

    static int roomCount = 1;
    static bool isConnectedToMaster = false;

    void Awake()
    {
        // If an instance exists and it is not this one, destroy this instance
        if (instance != null && instance != this)
            gameObject.SetActive(false);
        else
        {
            // Set the instance
            instance = this;
            DontDestroyOnLoad(gameObject);
        }

        PhotonNetwork.AutomaticallySyncScene = true;
    }

    void Start()
    {
        // Connect to the master server
        PhotonNetwork.ConnectUsingSettings();
    }

    public override void OnConnectedToMaster()
    {
        Debug.Log("Connected to master server");

        PhotonNetwork.JoinLobby();
        isConnectedToMaster = true;
    }

    // Attempts to create a room
    public void CreateRoom()
    {
        if (nameText.text.Length > 1 && isConnectedToMaster)
        {
            PhotonNetwork.LocalPlayer.NickName = nameText.text;
            PhotonNetwork.CreateRoom("Room " + roomCount, new RoomOptions { IsOpen = true, MaxPlayers = 2, IsVisible = true});
            roomCount++;

            mainMenu.SetActive(false);
            roomMenu.SetActive(true);
        }
    }

    public override void OnCreatedRoom()
    {
        Debug.Log("Created room: " + PhotonNetwork.CurrentRoom.Name);

        roomText.text = PhotonNetwork.CurrentRoom.Name;
    }

    // Attempts to join a room
    public void JoinRoom(string roomName)
    {
        PhotonNetwork.JoinRoom(roomName);
    }

    // Tries to join a room. If not possible, then creates a room
    public void TryToJoin(string roomName)
    {
        if (nameText.text.Length > 1 && isConnectedToMaster)
        {
            PhotonNetwork.LocalPlayer.NickName = nameText.text;
            PhotonNetwork.JoinOrCreateRoom(roomName, null, null, null);

            joinMenu.SetActive(false);
            roomMenu.SetActive(true);
        }
    }

    public override void OnJoinedRoom()
    {
        Debug.Log("Joined room");

        CountPlayers();
        UpdateRoomTexts();

        if (PhotonNetwork.CurrentRoom.PlayerCount == 2)
            ChangeScene("Game");
    }

    public void LeaveRoom()
    {
        Debug.Log("Left Room");

        PhotonNetwork.LeaveRoom();
    }

    public override void OnPlayerEnteredRoom(Player newPlayer)
    {
        CountPlayers();
        UpdateRoomTexts();

        if (PhotonNetwork.CurrentRoom.PlayerCount >= 2)
            ChangeScene("Game");
    }

    public override void OnPlayerLeftRoom(Player otherPlayer)
    {
        CountPlayers();
        UpdateRoomTexts();
    }

    public void CountPlayers()
    {
        Debug.Log("There are " + PhotonNetwork.CurrentRoom.PlayerCount + " players in the room");

        foreach (KeyValuePair<int, Player> player in PhotonNetwork.CurrentRoom.Players)
            Debug.Log("Name: " + player.Value.NickName);
    }

    public void UpdateRoomTexts()
    {
        roomText.text = PhotonNetwork.CurrentRoom.Name;

        for (int i = 0; i < playerTextList.Length; i++)
        {
            if (PhotonNetwork.CurrentRoom.Players.ContainsKey(i + 1))
                playerTextList[i].text = PhotonNetwork.CurrentRoom.Players[i + 1].NickName;
            else
                playerTextList[i].text = "";
        }
    }

    public override void OnRoomListUpdate(List<RoomInfo> roomList)
    {
        foreach (Transform child in scrollViewContent.transform)
            Destroy(child.gameObject);

        foreach (RoomInfo room in roomList)
        {
            GameObject rButton = Instantiate(roomButton);
            rButton.GetComponentInChildren<TextMeshProUGUI>().text = room.Name;
            rButton.GetComponent<Button>().onClick.AddListener(delegate { TryToJoin(room.Name); });

            if (scrollViewContent != null)
                rButton.transform.SetParent(scrollViewContent.transform, false);
        }
    }

    public void ChangeScene(string sceneName)
    {
        PhotonNetwork.LoadLevel(sceneName);
    }
}
