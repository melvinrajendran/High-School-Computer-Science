using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using Photon.Pun;

public class Movement : MonoBehaviourPun
{
    Rigidbody rb;
    [SerializeField] private float movementSpeed = 12f;
    [SerializeField] private float rotationSpeed = 2.75f;
    float inputZ = 0;
    float pitchForce;
    float jumpForce;
    bool isGrounded;

    void Start()
    {
        rb = GetComponent<Rigidbody>();
        rb.centerOfMass = new Vector3(0, -1f, 0);
        isGrounded = true;
        jumpForce = 4.5f;
        pitchForce = 5f;
    }

    void FixedUpdate()
    {
        if (photonView.IsMine)
            TakeInput();
    }

    void TakeInput()
    {
        if (isGrounded)
        {
            if (Input.GetMouseButton(1))
            {
                rb.AddRelativeForce(Vector3.up * jumpForce, ForceMode.Impulse);
            }
            if (Input.GetMouseButton(0) && GetComponent<Boost>().boost > 0)
            {
                GetComponent<Boost>().DecrementBoost(1);
                inputZ = Input.GetAxis("Fire1") * movementSpeed * (5f / 3f) * Time.fixedDeltaTime;
            }
            else if (Input.GetKey(KeyCode.W))
            {
                inputZ = Input.GetAxis("Vertical") * movementSpeed * Time.fixedDeltaTime;
            }
            else if (Input.GetKey(KeyCode.S))
            {
                inputZ = Input.GetAxis("Vertical") * movementSpeed * Time.fixedDeltaTime;
            }
            else
            {
                inputZ = Input.GetAxis("Vertical") * movementSpeed * Time.fixedDeltaTime;
            }
        }
        else
        {
            if (Input.GetMouseButton(0) && GetComponent<Boost>().boost > 0)
            {
                GetComponent<Boost>().DecrementBoost(1);
                inputZ = Input.GetAxis("Fire1") * movementSpeed * (5f / 3f) * Time.fixedDeltaTime;
            }
            rb.AddRelativeTorque(Vector3.right*Input.GetAxis("Vertical")*pitchForce, ForceMode.Acceleration);
        }
        rb.MovePosition(rb.position + transform.TransformDirection(new Vector3(0, 0, inputZ)));
        rb.angularVelocity = new Vector3(rb.angularVelocity.x, Input.GetAxis("Horizontal") * rotationSpeed, rb.angularVelocity.z);

    }

    void OnCollisionEnter(Collision theCollision)
    {
        if (theCollision.gameObject.name == "_Map")
        {
            isGrounded = true;
        }
    }

    void OnCollisionExit(Collision theCollision)
    {
        if (theCollision.gameObject.name == "_Map")
        {
            isGrounded = false;
        }
    }
    private void OnTriggerEnter(Collider other)
    {
        if (other.transform.CompareTag("Boost Pad") && other.transform.GetComponent<BoostPad>().isLit)
        {
            // Increment Boost
            transform.GetComponent<Boost>().IncrementBoost(other.GetComponent<BoostPad>().boostIncrement);

            // Begin Cool-down for Boost Pad
            other.transform.GetComponent<BoostPad>().lastUseTime = Time.time;
            other.transform.GetComponent<BoostPad>().isLit = false;
        }
    }
}