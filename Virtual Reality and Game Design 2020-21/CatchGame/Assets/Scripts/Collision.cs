using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class Collision : MonoBehaviour
{
    Text scoreText;
    static int score = 0;
    ParticleSystem pSystem;

    // Start is called before the first frame update
    void Start()
    {
        scoreText = GameObject.Find("ScoreText").GetComponent<Text>();
        pSystem = GetComponentInChildren<ParticleSystem>();
    }

    // Update is called once per frame
    void Update()
    {

    }

    private void OnBecameInvisible()
    {
        Destroy(gameObject);
    }

    private void OnCollisionEnter(UnityEngine.Collision collision)
    {
        pSystem.transform.parent = null;
        pSystem.transform.localScale = new Vector3(1.5f, 1.5f, 1.5f);
        pSystem.Stop();
        Destroy(pSystem.gameObject, 3f);


        Destroy(this.gameObject);

        score++;
        scoreText.text = score.ToString();
    }
}
