using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SpawnEnemy : MonoBehaviour
{
    public GameObject enemy;

    float nextTime;
    float interval;
    float randomX;

    // Start is called before the first frame update
    void Start()
    {
        nextTime = 1f;
        interval = 7f;
        randomX = Random.Range(-7f, 7f);
    }

    // Update is called once per frame
    void Update()
    {
        if (Time.time > nextTime)
        {
            nextTime += interval;
            Instantiate(enemy, new Vector3(randomX, 16, 0), Quaternion.Euler(new Vector3(90, 0, 0)));
            Instantiate(enemy, new Vector3(randomX, 17.5f, 0), Quaternion.Euler(new Vector3(90, 0, 0)));
            Instantiate(enemy, new Vector3(randomX, 19, 0), Quaternion.Euler(new Vector3(90, 0, 0)));
            randomX = Random.Range(-7f, 7f);
        }
    }
}
