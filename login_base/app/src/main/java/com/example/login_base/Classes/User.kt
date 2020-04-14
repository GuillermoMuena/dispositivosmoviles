package com.example.login_base.Classes

class User (name: String, pass: String){

    private var username : String
    private var password: String

    init {
        this.username = name
        this.password = pass
    }

    fun setUser (nombre : String){
        this.username =  nombre
    }

    fun getUser () : String {
        return(this.username)
    }

    fun setPass (pass : String) {
        this.password = pass
    }

    fun getPassword () : String {
        return(this.password)
    }

}