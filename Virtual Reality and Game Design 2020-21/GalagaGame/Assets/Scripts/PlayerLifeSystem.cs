using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class PlayerLifeSystem : MonoBehaviour
{
    public GameObject[] lifeImages;
    public Text restartText;

    public static int lifeCount;

    void Start()
    {
        lifeCount = 3;
        restartText.enabled = false;
        gameObject.GetComponent<PlayerMovement>().enabled = true;
        gameObject.GetComponent<PlayerShooting>().enabled = true;
    }

    void Update()
    {
        if (lifeCount < 1)
        {
            Destroy(lifeImages[0].gameObject);
            restartText.enabled = true;
            PauseGame();
        } else if (lifeCount < 2)
        {
            Destroy(lifeImages[1].gameObject);
        } else if (lifeCount < 3)
        {
            Destroy(lifeImages[2].gameObject);
        } else
        {
            ResumeGame();
        }
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (collision.gameObject.tag.Equals("Enemy"))
        {
            lifeCount--;
        }
    }

    public void PauseGame()
    {
        Time.timeScale = 0;
    }

    public void ResumeGame()
    {
        Time.timeScale = 1;
    }
}
