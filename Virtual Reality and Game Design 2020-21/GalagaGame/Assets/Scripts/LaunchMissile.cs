using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class LaunchMissile : MonoBehaviour
{
    public GameObject pSystem;
    Text scoreText;

    float moveSpeed;

    void Start()
    {
        scoreText = GameObject.Find("ScoreText").GetComponent<Text>();

        moveSpeed = 9f;
    }

    void Update()
    {
        transform.Translate(Vector2.up * Time.deltaTime * moveSpeed);
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (collision.gameObject.tag.Equals("Enemy"))
        {
            switch (collision.gameObject.name)
            {
                case "EnemyShip1(Clone)":
                    PlayerShooting.score += 150;
                    break;
                case "EnemyShip2(Clone)":
                    PlayerShooting.score += 100;
                    break;
                case "EnemyShip3(Clone)":
                    PlayerShooting.score += 75;
                    break;
                case "EnemyShip4(Clone)":
                    PlayerShooting.score += 50;
                    break;
                default:
                    break;
            }
            scoreText.text = PlayerShooting.score.ToString();

            GameObject clone = Instantiate(pSystem, collision.transform.position, collision.transform.rotation);
            clone.GetComponentInChildren<ParticleSystem>().Play();
            Destroy(clone, 2f);

            Destroy(collision.gameObject);
            Destroy(transform.gameObject);
        }
    }

    private void OnBecameInvisible()
    {
        Destroy(transform.gameObject);
    }
}
