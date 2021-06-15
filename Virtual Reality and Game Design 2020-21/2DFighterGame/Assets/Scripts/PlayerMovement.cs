using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.UI;

public class PlayerMovement : MonoBehaviour
{
    public Text restartText;

    Transform[] children;
    Animator animator;
    Camera camera;

    float hInput, vInput, hSpeed, vSpeed, expSpeed;
    bool isAttacking;

    void Start()
    {
        restartText.enabled = false;

        children = GetComponentsInChildren<Transform>();
        animator = GetComponent<Animator>();
        camera = Camera.main;

        hSpeed = 4f;
        vSpeed = 3f;
        expSpeed = 10f;
    }

    void Update()
    {
        hInput = Input.GetAxis("Horizontal");
        vInput = Input.GetAxis("Vertical");
        isAttacking = animator.GetCurrentAnimatorStateInfo(0).IsName("attack");

        // Toggling walk animation
        if (hInput != 0 || vInput != 0)
            animator.SetBool("walk", true);
        else
            animator.SetBool("walk", false);

        if (!isAttacking)
        {
            // Toggling scale to flip Player direction
            if (hInput > 0)
                transform.localScale = new Vector3(-0.5f, 0.5f, 0.5f);
            if (hInput < 0)
                transform.localScale = new Vector3(0.5f, 0.5f, 0.5f);

            // Player movement and clamping
            transform.Translate(new Vector2(hInput * hSpeed * Time.deltaTime, vInput * vSpeed * Time.deltaTime));
            transform.position = new Vector3(Mathf.Clamp(transform.position.x, -9.5f, 9.5f), Mathf.Clamp(transform.position.y, -4f, 4f), 0);

            // Calling attack animation on key press
            if (Input.GetKeyDown(KeyCode.Space))
                animator.SetTrigger("attack");
        }
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        // Exploding and destroying Player on impact with EnemySword
        if (collision.gameObject.name == "EnemySword" && collision.gameObject.GetComponentInParent<Animator>().GetCurrentAnimatorStateInfo(0).IsName("attack"))
        {
            camera.transform.parent = null;
            restartText.enabled = true;
            ExplodePlayer();
        }
    }

    public void ExplodePlayer()
    {
        children = GetComponentsInChildren<Transform>();

        Destroy(transform.Find("Shadow").gameObject);

        foreach (Transform child in children)
        {
            Vector2 randomVector = new Vector2(Mathf.Cos(Random.Range(0f, 260f)), Mathf.Sin(Random.Range(0f, 260f)));
            Rigidbody2D rb;
            if (child.gameObject.GetComponent<Rigidbody2D>() == null)
                rb = child.gameObject.AddComponent<Rigidbody2D>();
            else
                rb = child.gameObject.GetComponent<Rigidbody2D>();
            rb.isKinematic = false;
            rb.gravityScale = 1.0f;
            rb.AddForce(randomVector * expSpeed, ForceMode2D.Impulse);
        }

        Destroy(gameObject.GetComponent<Animator>());
        Destroy(gameObject, 4f);
    }
}
