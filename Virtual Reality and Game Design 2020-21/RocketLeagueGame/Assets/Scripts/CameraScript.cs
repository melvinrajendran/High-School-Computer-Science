using UnityEngine;
using System.Collections;

public class CameraScript : MonoBehaviour
{
    public Transform target;

    void Update()
    {
        if (!target)
        {
            var go = GameObject.FindWithTag("Player");
            if (go)
                target = go.transform;
        }

        if (target)
        {
            transform.position = new Vector3(target.position.x, target.position.y + 5f, target.position.z - 9f);
            transform.rotation = Quaternion.Euler(10f, 0f, 0f);
            transform.RotateAround(new Vector3(target.position.x, target.position.y, target.position.z), Vector3.up, target.transform.eulerAngles.y);
        }
    }
}