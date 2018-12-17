package org.inframincer.bmicalculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*
import org.jetbrains.anko.toast

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getStringExtra("height").toInt()
        val weight = intent.getStringExtra("weight").toInt()
        val bmi = weight / Math.pow(height / 100.0, 2.0)
        when {
            bmi >= 35 -> resultTextView.text = "extremely obese"
            bmi >= 30 -> resultTextView.text = "step 2 obese"
            bmi >= 25 -> resultTextView.text = "step 1 obese"
            bmi >= 23 -> resultTextView.text = "overweight"
            bmi >= 18.5 -> resultTextView.text = "normal"
            else -> resultTextView.text = "underweight"
        }
        when {
            bmi >= 23 -> imageView.setImageResource(R.drawable.ic_sentiment_very_dissatisfied_black_24dp)
            bmi >= 18.5 -> imageView.setImageResource(R.drawable.ic_sentiment_satisfied_black_24dp)
            else -> imageView.setImageResource(R.drawable.ic_sentiment_dissatisfied_black_24dp)
        }
        /*
       Toast.makeText(this, "$bmi", Toast.LENGTH_SHORT).show()
       */
        // to Anko
        toast("$bmi")
    }
}
