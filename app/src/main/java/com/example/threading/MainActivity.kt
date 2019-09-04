package com.example.threading

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun primes(): Sequence<Long> {
            var i = 0L
            return sequence {
                generateSequence { i++ }
                    .filter { n -> n > 1 && ((2 until n).none { i -> n % i == 0L }) }
                    .forEach { yield(it) }

                val progressBar = findViewById<ProgressBar>(R.id.progressBar)
                if (progressBar != null){
                    val text = findViewById<TextView>(R.id.textView)
                    text.setOnClickListener {
                        val visibility = if (progressBar.visibility == View.GONE) View.VISIBLE else View.GONE
                        progressBar.visibility = visibility

                        val Text = if(progressBar.visibility == View.GONE)"SHOW PROGRESSBAR" else "HIDE PROGRESSBAR"
                        text.text = Text
                    }

                }
            }
        }


    }
}
//commit


}
}
