package com.example.bookshelf.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bookshelf.classes.User

class usersViewModel : ViewModel() {

    val users = MutableLiveData<User>()
    lateinit var new_user : User
}