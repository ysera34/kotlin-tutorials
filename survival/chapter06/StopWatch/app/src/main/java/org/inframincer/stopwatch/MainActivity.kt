package org.inframincer.stopwatch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    private var time = 0
    private var isRunning = false
    private var timerTask: Timer? = null
    private var lap = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playFab.setOnClickListener {
            isRunning = !isRunning
            if (isRunning) {
                start()
            } else {
                pause()
            }
        }

        resetFab.setOnClickListener {
            reset()
        }

        lapButton.setOnClickListener {
            recordLapTime()
        }
    }
    private fun start() {
        playFab.setImageResource(R.drawable.ic_pause_black_24dp)
        timerTask = timer(period = 10) {
            time++
            val sec = time / 100
            val milli = time % 100
            runOnUiThread {
                hmTextView.text = "$sec"
                msTextView.text = "$milli"
            }
        }
    }
    private fun pause() {
        playFab.setImageResource(R.drawable.ic_play_arrow_black_24dp)
        timerTask?.cancel()
    }

    private fun reset() {
        timerTask?.cancel()
        time = 0
        isRunning = false
        playFab.setImageResource(R.drawable.ic_play_arrow_black_24dp)
        hmTextView.text = getString(R.string.init_second)
        msTextView.text = getString(R.string.init_milli_second)
        lapLayout.removeAllViews()
        lap = 1
    }
    private fun recordLapTime() {
        val lapTime = this.time
        val textView = TextView(this)
//        textView.text = "$lap LAB : ${lapTime / 100}.${lapTime % 100}"
        textView.text = getString(R.string.lap_time_format, lap, lapTime / 100, lapTime % 100)
        lapLayout.addView(textView, 0)
        lap++
    }
}
