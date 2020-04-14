package com.example.login_base.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.autofill.AutofillValue
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.login_base.Classes.User

import com.example.login_base.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    lateinit var v: View
    lateinit var btnLogin: Button
    lateinit var userText: EditText
    lateinit var passText: EditText
    private var verUser: Boolean = false
    private var verPass: Boolean = false

    private var users : MutableList<User> = ArrayList<User>()

    init{
        this.users.add(User("Pepito","12345"))
        this.users.add(User("Pedro","54321"))
        this.users.add(User("admin","admin"))
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_login, container, false)

        btnLogin = v.findViewById(R.id.buttonLogin)
        userText = v.findViewById(R.id.usernameText)
        passText = v.findViewById(R.id.passText)
        btnLogin.setText("Ingresar")
        userText.setHint("Nombre")
        passText.setHint("Contraseña")
        return v
    }


    override fun onStart() {
        super.onStart()
        btnLogin.setOnClickListener {
            for (userActual in users){
                if (userActual.getUser() == userText.text.toString()){
                    verUser = true
                    if(userActual.getPassword() == passText.text.toString()){
                        verPass = true
                    }
                }
            }
            if (!verUser){
                Snackbar.make(fragment_login, "Usuario Invalido", Snackbar.LENGTH_SHORT).show()
            }
            else{
                if (!verPass){
                    Snackbar.make(fragment_login, "Password Invalido", Snackbar.LENGTH_SHORT).show()
                }
                else{
                    verUser = false
                    verPass = false
                    val action2 = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
                    v.findNavController().navigate(action2)
                }
            }

        }
    }
}
