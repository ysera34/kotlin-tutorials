package org.inframincer.flashlight

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val torch = Torch(this)

        flashSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                torch.flashOn()
            } else {
                torch.flashOff()
            }
        }
    }
}
