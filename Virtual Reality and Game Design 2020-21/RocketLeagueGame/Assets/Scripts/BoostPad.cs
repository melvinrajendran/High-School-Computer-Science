using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BoostPad : MonoBehaviour
{
    public GameObject orb;
    public Material fullMaterial;
    public Material depletedMaterial;

    public int boostIncrement;
    public float cooldownTime;
    public float lastUseTime;
    public bool isLit;
    
    void Start()
    {
        lastUseTime = 0f;
    }

    void Update()
    {
        if (isLit)
        {
            GetComponent<MeshRenderer>().material = fullMaterial;
            if (orb != null)
                orb.SetActive(true);
        }
        else
        {
            GetComponent<MeshRenderer>().material = depletedMaterial;
            if (orb != null)
                orb.SetActive(false);

            if (Time.time > lastUseTime + cooldownTime)
                isLit = true;
        }
    }
}
