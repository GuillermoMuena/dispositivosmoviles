package com.example.bookshelf.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import com.example.bookshelf.R

val version_string = "Version 0.0.1"
val inc_name_string = "Red Lenses Panda Bear Inc."

class splash_activity : AppCompatActivity() {

    private lateinit var version : TextView
    private lateinit var label : TextView

    private val SPLASH_TIME_OUT:Long = 4500 // 1 sec
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_activity)
        version = findViewById(R.id.version)
        label = findViewById(R.id.inc_name)
        version.text = version_string
        version.textSize = 15F
        label.text =  inc_name_string
        label.textSize = 7.5F
        Handler().postDelayed({

            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)
    }
}
