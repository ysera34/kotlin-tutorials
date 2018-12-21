package org.inframincer.flashlight

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val torch = Torch(this)

        flashSwitch.setOnCheckedChangeListener { _, isChecked ->
//            val intent = Intent(this, TorchService::class.java)
            if (isChecked) {
//                torch.flashOn()
                /*
                intent.action = "on"
                startService(intent)
                */
                // for Anko
                startService(intentFor<TorchService>().setAction("on"))
            } else {
//                torch.flashOff()
                /*
                intent.action = "off"
                startService(intent)
                */
                // for Anko
                startService(intentFor<TorchService>().setAction("off"))
            }
        }
    }
}
