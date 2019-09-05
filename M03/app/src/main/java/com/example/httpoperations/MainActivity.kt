package com.example.httpoperations

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat.getSystemService
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        get_button.setOnClickListener {
            if (!isNetworkConnected()) {
                Snackbar.make(
                    it,
                    "Please check your internet connection and try again",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                startActivity(Intent(this@MainActivity, GetPickerActivity::class.java))
            }
        }
        post_button.setOnClickListener {
            if (!isNetworkConnected()) {
                Snackbar.make(
                    it,
                    "Please check your internet connection and try again",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                startActivity(Intent(this@MainActivity, PostActivity::class.java))
            }
        }
        put_button.setOnClickListener {
            if (!isNetworkConnected()) {
                Snackbar.make(
                    it,
                    "Please check your internet connection and try again",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                startActivity(Intent(this@MainActivity, PutActivity::class.java))
            }
        }
        delete_button.setOnClickListener {
            if (!isNetworkConnected()) {
                Snackbar.make(
                    it,
                    "Please check your internet connection and try again",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                startActivity(Intent(this@MainActivity, DeleteActivity::class.java))
            }
        }
    }


    private fun isNetworkConnected(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo?.isConnected == true
    }

}

