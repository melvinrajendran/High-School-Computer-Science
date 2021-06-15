using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MoveShip : MonoBehaviour
{
    float moveSpeed;
    float moveDistance;

    float rotationSpeed;
    float rotationAngle;

    Vector3 currentRotation;

    ParticleSystem pSystem;

    // Start is called before the first frame update
    void Start()
    {
        moveSpeed = 7.0f;
        rotationSpeed = -200f;
        currentRotation.y = 180;
        pSystem = GetComponentInChildren<ParticleSystem>();
    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetAxis("Horizontal") != 0)
        {
            moveDistance = Input.GetAxis("Horizontal") * Time.deltaTime * moveSpeed;
            transform.Translate(moveDistance, 0, 0);
            transform.position = new Vector3(Mathf.Clamp(transform.position.x, -7.5f, 7.5f), 6, 0);

            rotationAngle = Input.GetAxis("Horizontal") * Time.deltaTime * rotationSpeed;
            transform.Rotate(0, 0, rotationAngle, Space.Self);
            currentRotation = transform.eulerAngles;
            currentRotation.y = Mathf.Clamp(currentRotation.y, 135, 225);
            transform.localRotation = Quaternion.Euler(currentRotation);

            pSystem.Play();
        } else
        {
            if (currentRotation.y > 180)
            {
                currentRotation.y += Time.deltaTime * rotationSpeed;
            }
            else if (currentRotation.y < 180)
            {
                currentRotation.y -= Time.deltaTime * rotationSpeed;
            }
            if (Mathf.Abs(currentRotation.y - 180) < 0.5)
            {
                currentRotation.y = 180;
            }
            transform.rotation = Quaternion.RotateTowards(transform.rotation, Quaternion.Euler(-90, 0, currentRotation.y), 90);

            pSystem.Pause();
            pSystem.Clear();
        }
    }
}
