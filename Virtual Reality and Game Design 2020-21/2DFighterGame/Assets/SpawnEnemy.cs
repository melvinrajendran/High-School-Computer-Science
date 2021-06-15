using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SpawnEnemy : MonoBehaviour
{
    public GameObject player;
    public GameObject enemy;

    void Start()
    {
        // Calling Spawn method once every 10 seconds
        InvokeRepeating("Spawn", 0, 10);
    }

    void Spawn()
    {
        // Spawning an Enemy at a random position outside the view of the MainCamera
        int side = Random.Range(0, 2);
        if (side == 0)
            Instantiate(enemy, new Vector3(player.transform.position.x - 10, Random.Range(-4f, 4f), 0), enemy.transform.rotation);
        else
            Instantiate(enemy, new Vector3(player.transform.position.x + 10, Random.Range(-4f, 4f), 0), enemy.transform.rotation);
    }
}
