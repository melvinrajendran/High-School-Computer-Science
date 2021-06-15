using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using TMPro;

public class Boost : MonoBehaviour
{
    public TextMeshProUGUI boostText;
    public Image boostBar;
    Color blueColor = new Color(78, 120, 235, 1);

    public float boost;
    float maxBoost = 100;
    float lerpSpeed;

    void Update()
    {
        if (boostText != null)
            boostText.text = boost.ToString();

        lerpSpeed = 3f * Time.deltaTime;

        if (boostBar != null)
        {
            BoostBarFiller();
            ColorChanger();
        }
    }

    void BoostBarFiller()
    {
        boostBar.fillAmount = Mathf.Lerp(boostBar.fillAmount, (boost / maxBoost) * 0.6f, lerpSpeed);
    }

    void ColorChanger()
    {
        Color boostColor = Color.Lerp(Color.white, blueColor, (boost / maxBoost));

        boostBar.color = boostColor;
    }

    public void DecrementBoost(int boostPoints)
    {
        boost -= boostPoints;
        if (boost < 0)
            boost = 0;
    }

    public void IncrementBoost(int boostPoints)
    {
        boost += boostPoints;
        if (boost > maxBoost)
            boost = maxBoost;
    }
}
