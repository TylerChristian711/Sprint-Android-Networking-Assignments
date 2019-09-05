package com.example.httpoperations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_get_picker.*

class GetPickerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_picker)

        get_call_button.setOnClickListener {
            val intent = Intent(this@GetPickerActivity,GetPickerActivity::class.java)
            intent.putExtra("get","simple")
            startActivity(intent)
        }
        get_call_parameter_button.setOnClickListener {
            val intent = Intent(this@GetPickerActivity,GetPickerActivity::class.java)
            intent.putExtra("get","path")
            startActivity(intent)
        }
        get_query_button.setOnClickListener {
            val intent = Intent(this@GetPickerActivity,GetPickerActivity::class.java)
            intent.putExtra("get","query")
            startActivity(intent)
        }
    }
}
