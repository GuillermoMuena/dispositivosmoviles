package com.example.bookshelf.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.bookshelf.R
import com.example.bookshelf.classes.Constants
import com.example.bookshelf.classes.User
import com.example.bookshelf.database.appDatabase
import com.example.bookshelf.database.userDao
import com.example.bookshelf.viewmodels.usersViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_login_fragment.*

const val language_value : String = "es"

class login_fragment : Fragment() {

    companion object {
        fun newInstance() = login_fragment()
    }

    lateinit var v : View

    private var db: appDatabase? = null
    private var userDao: userDao? = null

    lateinit var username       : EditText
    lateinit var password       : EditText
    lateinit var login_btn      : Button
    lateinit var new_user_btn   : Button
    lateinit var user_list      : MutableList<User>
    private var consts = Constants(language_value)
    private lateinit var viewModel: usersViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_login_fragment, container, false)
        username    = v.findViewById(R.id.username)                             // Locate the username input by id
        password    = v.findViewById(R.id.password)                             // Locate the password input by id
        login_btn   = v.findViewById(R.id.login)                                // Locate the login button by id
        new_user_btn= v.findViewById(R.id.new_user)                             // Locate the new user button by id
        username.hint = consts.get_user_hint()
        password.hint = consts.get_pass_hint()
        login_btn.text = consts.get_login_text()
        new_user_btn.text = consts.get_new_user_text()
        setHasOptionsMenu(true)
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        db = appDatabase.getAppDataBase(v.context)
        userDao = db?.userDao()

        viewModel = ViewModelProvider(requireActivity()).get(usersViewModel::class.java)
        viewModel.users.observe(viewLifecycleOwner, Observer { result ->

            userDao?.insertPerson(User(result.email,result.name, result.pass))
        })
    }

    override fun onStart() {
        super.onStart()

        db = appDatabase.getAppDataBase(v.context)
        userDao = db?.userDao()

        new_user_btn.setOnClickListener {

            val action = login_fragmentDirections.actionMainFragment3ToNewUser2()
            v.findNavController().navigate(action)
        }

        login_btn.setOnClickListener {

            user_list = userDao?.loadAllPersons() as MutableList<User>
            for (actual_user in user_list) {
                if (actual_user.name == username.text.toString()) {
                    if(actual_user.pass == password.text.toString()) {
                        val action = login_fragmentDirections.actionMainFragment3ToListFragment()
                        v.findNavController().navigate(action)
                    }
                }
                else {
                    val login_error : String = consts.get_login_error_msg()
                    Snackbar.make(v, login_error, Snackbar.LENGTH_SHORT).show()
                }

            }
        }

    }
}
