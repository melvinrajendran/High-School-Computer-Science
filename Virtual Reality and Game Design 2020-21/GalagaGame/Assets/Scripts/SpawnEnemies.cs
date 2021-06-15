using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SpawnEnemies : MonoBehaviour
{
    public GameObject enemy1;
    public GameObject enemy2;
    public GameObject enemy3;
    public GameObject enemy4;

    float timeInterval;

    void Start()
    {
        DestroyEnemies();
        timeInterval = 0f;
    }

    void Update()
    {
        if (Time.time > timeInterval)
        {
            int random = Random.Range(0, 4);

            switch (random)
            {
                case 0: Instantiate(enemy1); break;
                case 1: Instantiate(enemy2); break;
                case 2: Instantiate(enemy3); break;
                case 3: Instantiate(enemy4); break;
            }

            timeInterval += (5f / LevelSystem.level);
        }
    }

    public void DestroyEnemies()
    {
        foreach (GameObject o in FindObjectsOfType<GameObject>())
            if (o.name.Contains("EnemyShip"))
            {
                Destroy(o.gameObject);
                Debug.Log("DEstroyed");
            }
                
    }
}
