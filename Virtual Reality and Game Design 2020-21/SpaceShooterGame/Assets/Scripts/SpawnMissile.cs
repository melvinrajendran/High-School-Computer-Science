using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SpawnMissile : MonoBehaviour
{
    public GameObject missile;  
    public GameObject leftSpawnPoint;
    public GameObject rightSpawnPoint;

    static int count;

    void Start()
    {
        count = 0;
    }

    void Update()
    {
        if (Input.GetKeyDown(KeyCode.Space))
        {
            if (count % 2 == 0)
            {
                Instantiate(missile, leftSpawnPoint.transform.position, leftSpawnPoint.transform.rotation);
            } else
            {
                Instantiate(missile, rightSpawnPoint.transform.position, rightSpawnPoint.transform.rotation);
            }
            count++;
        }
    }
}
