using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Spawn : MonoBehaviour
{
    public GameObject gameObject;

    private float nextTime;
    private float interval;

    // Start is called before the first frame update
    void Start()
    {
        nextTime = 1.0f;
        interval = 2.0f;
    }

    // Update is called once per frame
    void Update()
    {
        if (Time.time > nextTime)
        {
            nextTime += interval;
            Instantiate(gameObject, new Vector3(Random.Range(-10, 10), 21, Random.Range(0, 20)), transform.rotation);
        }
    }
}
