using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.UI;

public class RestartLevel : MonoBehaviour
{
    void Update()
    {
        // Restarting the Scene on a key press
        if (Input.GetKeyDown(KeyCode.R))
            SceneManager.LoadScene("LevelOne");
    }
}
