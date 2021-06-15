using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerShooting : MonoBehaviour
{
    public GameObject missile;
    public GameObject spawnLocation;

    public static int score;
    float lastFireTime;

    void Start()
    {
        score = 0;
        lastFireTime = 0f;
    }

    void Update()
    {
        if (Input.GetKey(KeyCode.Space) && Time.time > lastFireTime + 0.25f)
        {
            Instantiate(missile, spawnLocation.transform.position, spawnLocation.transform.rotation);
            lastFireTime = Time.time;
        }
    }
}
