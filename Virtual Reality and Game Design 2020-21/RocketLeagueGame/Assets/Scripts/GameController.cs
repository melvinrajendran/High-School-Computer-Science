using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using Photon.Pun;
using Photon.Realtime;
using TMPro;

public class GameController : MonoBehaviourPun
{
    public static GameController instance;

    public Transform[] spawnPoints;
    public Camera mainCamera;

    GameObject photonPlayer;
    Player[] allPlayers;
    int myNumberInRoom = 0;

    // Start is called before the first frame update
    void Start()
    {
        if (instance == null)
            instance = this;

        myNumberInRoom = 0;

        allPlayers = PhotonNetwork.PlayerList;
        foreach (Player p in allPlayers)
        {
            if (p != PhotonNetwork.LocalPlayer)
            {
                myNumberInRoom++;
            }
        }

        Debug.Log("My number: " + myNumberInRoom);

        if (myNumberInRoom == 0)
        {
            photonPlayer = PhotonNetwork.Instantiate(Resources.Load<GameObject>("PlayerOne").name, spawnPoints[0].position, Quaternion.identity);
        }
        else if (myNumberInRoom == 1)
        {
            photonPlayer = PhotonNetwork.Instantiate(Resources.Load<GameObject>("PlayerTwo").name, spawnPoints[1].position, Quaternion.identity);
        }

        mainCamera.enabled = false;
        photonPlayer.GetComponentInChildren<Boost>().boostText = GameObject.Find("Boost Text").GetComponent<TextMeshProUGUI>();
        photonPlayer.GetComponentInChildren<Boost>().boostBar = GameObject.Find("Boost Bar Overlay").GetComponent<Image>();
        photonPlayer.GetComponentInChildren<Camera>().enabled = true;
    }

    public void ResetPositions()
    {
        
    }
}
