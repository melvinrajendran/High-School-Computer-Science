using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerMovement : MonoBehaviour
{
    Animator animator;
    public static GameObject player;

    float moveSpeed, moveDistance;

    void Start()
    {
        animator = GetComponent<Animator>();
        player = this.gameObject;
        //player.transform.position = new Vector3(0, 0, 0);

        moveSpeed = 6f;
    }

    void Update()
    {
        // Clamped Movement
        moveDistance = Input.GetAxis("Horizontal") * Time.deltaTime * moveSpeed;
        transform.Translate(moveDistance, 0, 0);
        transform.position = new Vector3(Mathf.Clamp(transform.position.x, -7.5f, 7.5f), transform.position.y, transform.position.z);

        // Animation
        if (Input.GetAxis("Horizontal") != 0)
            animator.SetBool("spin", true);
        else
            animator.SetBool("spin", false);
    }
}
