package com.example.login_base.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.login_base.R

class WelcomeFragment : Fragment() {

    lateinit var welcomeText: TextView
    lateinit var v: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_welcome, container, false)

        welcomeText = v.findViewById(R.id.welcome_text)
        welcomeText.textSize = 20F
        welcomeText.text = "Bienvenido"

        return v
    }
}
