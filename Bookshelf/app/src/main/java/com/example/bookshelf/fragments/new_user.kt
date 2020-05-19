package com.example.bookshelf.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController

import com.example.bookshelf.R
import com.example.bookshelf.classes.Constants
import com.example.bookshelf.classes.User
import com.example.bookshelf.viewmodels.usersViewModel

class new_user : Fragment() {

    companion object {
        fun newInstance() = new_user()
    }

    lateinit var v : View
    lateinit var email          : EditText
    lateinit var username       : EditText
    lateinit var password       : EditText
    lateinit var create_btn     : Button
    private lateinit var viewModel: usersViewModel

    private var consts = Constants(language_value)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_new_user, container, false)
        email       = v.findViewById(R.id.email)
        username    = v.findViewById(R.id.username)         // Locate the username input by id
        password    = v.findViewById(R.id.password)         // Locate the password input by id
        create_btn  = v.findViewById(R.id.create_btn)       // Locate the create button by id
        username.hint = consts.get_user_hint()              // Set the username hint according to the language
        password.hint = consts.get_pass_hint()              // Set the password hint according to the language
        email.hint = consts.get_email_hint()                // Set the email hint according to the language
        create_btn.text = consts.get_create_text()           // Set the create button name according to the language
        setHasOptionsMenu(true)
        return v
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(usersViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        create_btn.setOnClickListener {
            var new : User = User(email.text.toString(), username.text.toString(),password.text.toString())
            viewModel.users.value = new

            val action = new_userDirections.actionNewUser2ToMainFragment3()
            v.findNavController().navigate(action)
        }
    }

}
