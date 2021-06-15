using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MoveEnemy : MonoBehaviour
{
    float moveSpeed;
    public ParticleSystem particleSystem;
    float initialY, initialX;
    int random, stage;

    void Start()
    {
        moveSpeed = 2;
        initialX = transform.position.x;
        initialY = transform.position.y;
        stage = 1;
    }

    void Update()
    {
        switch (stage)
        {
            case 1:
                if (transform.position.y > 10)
                {
                    transform.Translate(0, -moveSpeed * Time.deltaTime, 0, Space.World);
                } else
                {
                    stage++;
                }
                break;
            case 2:
                if (initialX > 0)
                {
                    if (transform.position.x > -5)
                    {
                        transform.Translate(-moveSpeed * Time.deltaTime, 0, 0, Space.World);
                    }
                    else
                    {
                        stage++;
                    }
                }
                else
                {
                    if (transform.position.x < 5)
                    {
                        transform.Translate(moveSpeed * Time.deltaTime, 0, 0, Space.World);
                    }
                    else
                    {
                        stage++;
                    }
                }
                break;
            case 3:
                if (transform.position.y > -5)
                {
                    transform.Translate(0, -moveSpeed * Time.deltaTime, 0, Space.World);
                }
                else
                {
                    stage++;
                }
                break;
            default:
                break;
        }
    }

    private void OnCollisionEnter(Collision collision)
    {
        if (collision.collider.name.Contains("EnemySparrow"))
        {
            Destroy(gameObject);
            Destroy(collision.collider.gameObject);
            Instantiate(particleSystem, collision.transform.position, collision.transform.rotation);
            particleSystem.Play();
            particleSystem.Stop();
        }
        if (collision.collider.name == "PlayerSparrow")
        {
            Destroy(gameObject);
            Instantiate(particleSystem, collision.transform.position, collision.transform.rotation);
            particleSystem.Play();
            particleSystem.Stop();
        }
    }

    private void OnBecameInvisible()
    {
        Destroy(gameObject);
    }
}
