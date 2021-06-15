using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class LaunchMissile : MonoBehaviour
{
    float missileSpeed;
    public ParticleSystem particleSystem;

    void Start()
    {
        missileSpeed = 10f;
    }

    void Update()
    {
        transform.Translate(new Vector3(0, missileSpeed * Time.deltaTime, 0), Space.World);
    }

    private void OnCollisionEnter(Collision collision)
    {
        if (collision.collider.name.Contains("EnemySparrow"))
        {
            Destroy(gameObject);
            Destroy(collision.collider.gameObject);
            Instantiate(particleSystem, collision.transform.position, collision.transform.rotation);
            particleSystem.Play();
            particleSystem.Stop();
        }
    }

    private void OnBecameInvisible()
    {
        Destroy(gameObject);
    }
}
