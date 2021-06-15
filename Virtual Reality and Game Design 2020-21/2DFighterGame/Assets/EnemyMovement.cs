using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class EnemyMovement : MonoBehaviour
{
    public GameObject hpBar;
    public GameObject background;
    public GameObject border;

    GameObject target;
    Transform[] children;
    Animator animator;
    Vector2 xDirection, yDirection;

    float xSpeed, ySpeed, expSpeed, randomHit;
    int numHits, moveDirection;
    bool shouldMoveHorizontal, shouldMoveVertical, isAttacking, didStop;

    void Start()
    {
        target = GameObject.FindWithTag("Player");
        children = GetComponentsInChildren<Transform>();
        animator = GetComponent<Animator>();

        xSpeed = 3f;
        ySpeed = 2.25f;
        expSpeed = 5f;
        randomHit = Random.Range(0, 3.9f);
        numHits = 0;
        moveDirection = Random.Range(0, 2);
        didStop = false;
    }

    void Update()
    {
        isAttacking = animator.GetCurrentAnimatorStateInfo(0).IsName("attack");

        // Updating the directions in which the Enemy should move to approach the Player
        if (target.transform.position.x < transform.position.x)
            xDirection = Vector2.left;
        if (target.transform.position.x > transform.position.x)
            xDirection = Vector2.right;
        if (target.transform.position.y < transform.position.y)
            yDirection = Vector2.down;
        if (target.transform.position.y > transform.position.y)
            yDirection = Vector2.up;

        // Determining if the Enemy is far enough from the Player
        shouldMoveHorizontal = Mathf.Abs(transform.position.x - target.transform.position.x) >= 1.5f;
        shouldMoveVertical = Mathf.Abs(transform.position.y - target.transform.position.y) >= 1f;
        
        // Creating a time-based interval for the Enemy to randomly move and attack
        if (Time.time % 10 < 3)
        {         
            if (moveDirection == 0 && shouldMoveHorizontal && !didStop)
            {
                // Toggling scale to flip Enemy direction
                if (xDirection == Vector2.right)
                    transform.localScale = new Vector3(-0.5f, 0.5f, 0.5f);
                if (xDirection == Vector2.left)
                    transform.localScale = new Vector3(0.5f, 0.5f, 0.5f);

                transform.Translate(xDirection * xSpeed * Time.deltaTime);
                animator.SetBool("walk", true);
            }
            else if (moveDirection == 1 && shouldMoveVertical && !didStop)
            {
                transform.Translate(yDirection * ySpeed * Time.deltaTime);
                animator.SetBool("walk", true);
            } else
            {
                didStop = true;
                animator.SetBool("walk", false);
            }
        }
        else
        {
            RandomizeDirection();
            animator.SetBool("walk", false);
            if (!isAttacking && Time.time % 4 < randomHit + 0.025f && Time.time % 4 > randomHit - 0.025f)
                animator.SetTrigger("attack");
            didStop = false;
        }
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        // Enemy takes three hits before exploding and being destroyed
        if (collision.gameObject.name == "Sword" && collision.gameObject.GetComponentInParent<Animator>().GetCurrentAnimatorStateInfo(0).IsName("attack"))
        {
            hpBar.transform.localScale += new Vector3(-0.5f, 0, 0);
            numHits++;

            if (numHits < 3)
                animator.SetTrigger("hit");
            else
                ExplodeEnemy();
        }
    }

    public void ExplodeEnemy()
    {
        Destroy(transform.Find("Shadow").gameObject);
        Destroy(hpBar);
        Destroy(background);
        Destroy(border);

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

    public void RandomizeDirection()
    {
        moveDirection = Random.Range(0, 2);
    }
}