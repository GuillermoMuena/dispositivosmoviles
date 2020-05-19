package com.example.bookshelf.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bookshelf.classes.Book

class bookViewModel : ViewModel() {

    val books = MutableLiveData<Book>()
    lateinit var new_book : Book
}