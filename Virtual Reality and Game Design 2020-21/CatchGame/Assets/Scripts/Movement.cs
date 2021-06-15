using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Movement : MonoBehaviour
{
    public float speed;

    // Start is called before the first frame update
    void Start()
    {
        speed = 10f;
    }

    // Update is called once per frame
    void Update()
    {
        transform.Translate(speed * Input.GetAxis("Horizontal") * Time.deltaTime, 0, speed * Input.GetAxis("Vertical") * Time.deltaTime);
    }
}
