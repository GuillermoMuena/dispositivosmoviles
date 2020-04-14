package com.example.textappmuena

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var txtLabel : TextView
    lateinit var btnShow : Button
    lateinit var btnHide : Button
    lateinit var btnPlus : Button
    lateinit var btnMinus : Button
    lateinit var btnRed : Button
    lateinit var btnGreen : Button
    lateinit var btnBlue : Button
    lateinit var btnCyan : Button
    lateinit var btnMag : Button
    lateinit var btnYellow : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtLabel = findViewById(R.id.textView)                 //Referencia de vistas al xml
        btnShow = findViewById(R.id.buttonShow)
        btnHide = findViewById(R.id.buttonHide)
        btnPlus = findViewById(R.id.buttonPlus)
        btnMinus = findViewById(R.id.buttonMinus)
        btnRed = findViewById(R.id.buttonRed)
        btnGreen = findViewById(R.id.buttonGreen)
        btnBlue = findViewById(R.id.buttonBlue)
        btnCyan = findViewById(R.id.buttonCyan)
        btnMag = findViewById(R.id.buttonMagenta)
        btnYellow = findViewById(R.id.buttonYellow)

        txtLabel.text = "Texto de ejemplo"

        btnShow.setOnClickListener {
            txtLabel.text = "Texto de ejemplo"
        }

        btnHide.setOnClickListener {
            txtLabel.text = " "
        }

        btnPlus.setOnClickListener {
            txtLabel.setTextSize(0, txtLabel.textSize + 1)
        }

        btnMinus.setOnClickListener {
            txtLabel.setTextSize(0, txtLabel.textSize - 1)
        }

        btnRed.setOnClickListener {
            txtLabel.setTextColor(Color.RED)
        }

        btnGreen.setOnClickListener {
            txtLabel.setTextColor(Color.GREEN)
        }

        btnBlue.setOnClickListener {
            txtLabel.setTextColor(Color.BLUE)
        }

        btnCyan.setOnClickListener {
            txtLabel.setTextColor(Color.CYAN)
        }

        btnMag.setOnClickListener {
            txtLabel.setTextColor(Color.MAGENTA)
        }

        btnYellow.setOnClickListener {
            txtLabel.setTextColor(Color.YELLOW)
        }
    }
}