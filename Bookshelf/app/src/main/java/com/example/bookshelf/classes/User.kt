package com.example.bookshelf.classes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class User (email: String, name: String, pass: String){

    @PrimaryKey
    @ColumnInfo (name = "email")
    var email: String = email

    @ColumnInfo (name = "name")
    var name : String = name


    @ColumnInfo(name = "pass")
    var pass : String = pass
}