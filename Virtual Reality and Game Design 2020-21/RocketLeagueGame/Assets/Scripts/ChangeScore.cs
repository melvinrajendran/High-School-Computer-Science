using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;

public class ChangeScore : MonoBehaviour
{
    public TextMeshProUGUI scoreText;
    public TextMeshProUGUI alertText;
    public TimeController timeController;

    public int score;

    private void Start()
    {
        score = 0;
        alertText.enabled = false;
    }

    private void Update()
    {
        scoreText.text = score.ToString();
    }

    void IncreaseScore()
    {
        score++;
    }

    void IncreaseScore(int increment)
    {
        score += increment;
    }

    void ResetScore()
    {
        score = 0;
    }

    private void OnTriggerEnter(Collider other)
    {
        if (other.name.Equals("Ball"))
        {
            IncreaseScore();

            timeController.DoSlowMotion();

            alertText.enabled = true;
            if (transform.name.Contains("Two"))
                alertText.text = "Player One Scored!";
            else
                alertText.text = "Player Two Scored!";

            Invoke("ResetPrefabPositions", 5.0f);
        }
    }

    void ResetPrefabPositions()
    {
        alertText.enabled = false;
        //GameController.instance.ResetPositions(); reset positions somehow
    }
}
