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
import com.example.bookshelf.viewmodels.bookDetailsViewModel
import kotlinx.android.synthetic.main.fragment_new_book.view.*

class tab_complex : Fragment() {

    lateinit var editorial : TextView
    lateinit var anno: TextView
    lateinit var pages: TextView
    lateinit var theme: TextView
    lateinit var ISBN: TextView
    lateinit var v :View

    private lateinit var viewModel : bookDetailsViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v =  inflater.inflate(R.layout.fragment_tab_complex, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(bookDetailsViewModel::class.java)

        editorial = v.findViewById(R.id.Editorial)
        anno = v.findViewById(R.id.Year)
        pages = v.findViewById(R.id.Pages)
        theme = v.findViewById(R.id.theme)
        ISBN = v.findViewById(R.id.ISBN)

        viewModel.books.observe(viewLifecycleOwner, Observer { result ->
            editorial.text = result.editorial
            theme.text = result.topic
            ISBN.text = result.ISBN
            anno.text = result.year.toString()
            pages.text = result.pages.toString()
        })

       return v
    }
}
