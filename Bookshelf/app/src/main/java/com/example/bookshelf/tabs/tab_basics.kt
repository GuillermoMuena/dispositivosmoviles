package com.example.bookshelf.tabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.example.bookshelf.R
import com.example.bookshelf.classes.Book
import com.example.bookshelf.viewmodels.bookDetailsViewModel

class tab_basics : Fragment() {

    lateinit var title : TextView
    lateinit var author: TextView
    lateinit var cover: ImageView
    lateinit var v :View

    private lateinit var viewModel : bookDetailsViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v =  inflater.inflate(R.layout.fragment_tab_basics, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(bookDetailsViewModel::class.java)

        title = v.findViewById(R.id.Titulo)
        author = v.findViewById(R.id.Autor)
        cover = v.findViewById(R.id.cover)

        viewModel.books.observe(viewLifecycleOwner, Observer { result ->
            title.text = result.title
            author.text = result.author
        })

        return v
    }
}
