package org.inframincer.bmicalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultButton.setOnClickListener {
            /*
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("height", heightEditText.text.toString())
            intent.putExtra("weight", weightEditText.text.toString())
            startActivity(intent)
            */
            // to Anko
            startActivity<ResultActivity>(
                    "height" to heightEditText.text.toString(),
                    "weight" to weightEditText.text.toString()
            )
        }
    }
}
