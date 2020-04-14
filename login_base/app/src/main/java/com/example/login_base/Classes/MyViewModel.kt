package com.example.login_base.Classes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    private var users : MutableList<User> = ArrayList<User>()

    init{
        this.users.add(User("Pepito","12345"))
        this.users.add(User("Pedro","54321"))
        this.users.add(User("admin","admin"))
    }

    fun getUsers (): MutableList<User> {
        return(this.users)
    }

}