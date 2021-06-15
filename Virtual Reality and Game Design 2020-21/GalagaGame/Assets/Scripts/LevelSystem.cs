using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class LevelSystem : MonoBehaviour
{
    Text levelText;

    public static int level;
    int scoreThreshold = 1000;

    void Start()
    {
        level = 1;
        levelText = GameObject.Find("LevelText").GetComponent<Text>();
        levelText.text = level.ToString();
    }

    void Update()
    {
        if (PlayerShooting.score > scoreThreshold)
        {
            scoreThreshold += 1000;

            level++;
            levelText.text = level.ToString();
        }
    }
}
