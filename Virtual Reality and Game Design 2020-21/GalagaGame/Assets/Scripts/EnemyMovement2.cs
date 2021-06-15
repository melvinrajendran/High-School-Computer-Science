using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using Unity.MLAgents;
using Unity.MLAgents.Actuators;
using Unity.MLAgents.Sensors;

public class EnemyMovement2 : Agent
{
    public float moveSpeed = 5f;
    public float turnSpeed = 180f;
    private int count;
    public Transform player;
    Rigidbody2D rigidbody1;

    public override void Initialize()
    {
        base.Initialize();
        rigidbody1 = GetComponentInChildren<Rigidbody2D>();
        count = 1500;
    }

    public override void OnEpisodeBegin()
    {
        player.localPosition = new Vector3(Random.Range(-7.0f, 7.0f), 0f);
        transform.localPosition = new Vector3(Random.Range(-7.0f, 7.0f), 7.7f);
    }

    public override void OnActionReceived(ActionBuffers actionBuffers)
    {
        // Convert the first action to forward movement
        float forwardAmount = actionBuffers.DiscreteActions[0];

        // Convert the second action to turning left or right
        float turnAmount = 0f;
        if (actionBuffers.DiscreteActions[1] == 1f)
        {
            turnAmount = -1f;
        }
        else if (actionBuffers.DiscreteActions[1] == 2f)
        {
            turnAmount = 1f;
        }

        // Apply movement
        rigidbody1.MovePosition(transform.position + transform.forward * forwardAmount * moveSpeed * Time.fixedDeltaTime);
        transform.Rotate(transform.up * turnAmount * turnSpeed * Time.fixedDeltaTime);

        // Apply a tiny negative reward every step to encourage action
        if (MaxStep > 0) AddReward(-1f / MaxStep);
    }

    public override void Heuristic(in ActionBuffers actionsOut)
    {
        int forwardAction = 0;
        int turnAction = 0;
        Debug.Log("Heuristic");
        if (Input.GetKey(KeyCode.W))
        {
            // move forward
            Debug.Log("W");
            forwardAction = 1;
        }
        if (Input.GetKey(KeyCode.A))
        {
            // turn left
            turnAction = 1;
        }
        else if (Input.GetKey(KeyCode.D))
        {
            // turn right
            turnAction = 2;
        }

        // Put the actions into the array
        actionsOut.DiscreteActions.Array[0] = forwardAction;
        actionsOut.DiscreteActions.Array[1] = turnAction;
    }

    public override void CollectObservations(VectorSensor sensor)
    {
        // Distance to the player (1 float = 1 value)
        sensor.AddObservation(Vector3.Distance(player.transform.position, transform.position));

        // Direction to player (1 Vector3 = 3 values)
        sensor.AddObservation((player.transform.position - transform.position).normalized);

        // Direction enemy is facing (1 Vector3 = 3 values)
        sensor.AddObservation(transform.forward);
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (collision.gameObject.name.Equals("PlayerShip"))
        {
            Debug.Log("HIT SHIP");
        }

        else
        {
            Debug.Log("HIT SOMETHING ELSE");
            SetReward(-3);
        }

        EndEpisode();
    }
}
