using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Rotation : MonoBehaviour
{
    Vector3 bottomPoint;
    // Start is called before the first frame update
    void Start()
    {
        bottomPoint = transform.position - new Vector3(0, transform.localScale.y / 2, 0);
    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetKey(KeyCode.UpArrow))
        {
            transform.RotateAround(bottomPoint, new Vector3(0, 0, 1), 90 * Time.deltaTime);
        }
        if (Input.GetKey(KeyCode.DownArrow))
        {
            transform.RotateAround(bottomPoint, new Vector3(0, 0, 1), -90 * Time.deltaTime);
        }
    }
}