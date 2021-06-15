using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using Unity.MLAgents;
using Unity.MLAgents.Sensors;
using Unity.MLAgents.Actuators;

// Curriculum Learning
public class EnemyMovement : Agent
{
    private int count;
    float moveSpeed = 2f;

    public override void OnEpisodeBegin()
    {
        count = 1500;
        //PlayerMovement.player.transform.localPosition = new Vector3(Random.Range(-7.0f, 7.0f), 0f);
        transform.localPosition = new Vector3(Random.Range(-7.0f, 7.0f), 9f);
    }

    public override void OnActionReceived(float[] vectorAction)
    {
        transform.Translate(Vector3.down * Time.deltaTime);
        for (int i = 0; i < vectorAction.Length; i++)
        {
            transform.Translate(new Vector3(vectorAction[0], vectorAction[1], 0) * Time.deltaTime * moveSpeed);
        }
        count--;
        if (count <= 0)
        {
            SetReward(-2);
            EndEpisode();
        }
    }

    public override void CollectObservations(VectorSensor sensor)
    {
        sensor.AddObservation(transform.localPosition);
        sensor.AddObservation(PlayerMovement.player.transform.localPosition);
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (collision.gameObject.tag.Equals("Player")) {
            if (count > 1000)
                SetReward(5);
            else if (count > 800)
                SetReward(4);
            else if (count > 500)
                SetReward(3);
            else if (count > 300)
                SetReward(2);
            else
                SetReward(1);
            EndEpisode();
        }
    }

    private void Update()
    {
        if (transform.position.y <= -0.1f)
            Destroy(gameObject);
    }
}