package com.example.bookshelf.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.EditText
import android.widget.ImageButton
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController

import com.example.bookshelf.R
import com.example.bookshelf.classes.Book
import com.example.bookshelf.classes.User
import com.example.bookshelf.viewmodels.bookViewModel
import com.example.bookshelf.viewmodels.usersViewModel

class new_book : Fragment() {
    companion object {
        fun newInstance() = new_book()
    }

    lateinit var v : View
    lateinit var title_edit      : EditText
    lateinit var author_edit     : EditText
    lateinit var editorial_edit  : EditText
    lateinit var cover_edit      : EditText
    lateinit var pages_edit      : EditText
    lateinit var year_edit       : EditText
    lateinit var topic_edit      : EditText
    lateinit var ISBN_edit       : EditText
    lateinit var review_edit     : EditText
    lateinit var btn_add         : ImageButton

    private lateinit var viewModel: bookViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_new_book, container, false)

        title_edit      = v.findViewById(R.id.title)
        author_edit     = v.findViewById(R.id.author)
        editorial_edit  = v.findViewById(R.id.editorial)
        cover_edit      = v.findViewById(R.id.cover)
        pages_edit      = v.findViewById(R.id.pages)
        year_edit       = v.findViewById(R.id.year)
        topic_edit      = v.findViewById(R.id.topic)
        ISBN_edit       = v.findViewById(R.id.ISBN)
        review_edit     = v.findViewById(R.id.review)
        btn_add         = v.findViewById(R.id.fab_add)
        return v
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setHasOptionsMenu(true)
        viewModel = ViewModelProvider(requireActivity()).get(bookViewModel::class.java)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_toolbar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onStart() {
        super.onStart()
        btn_add.setOnClickListener {
            var new : Book = Book(ISBN_edit.text.toString(),
                                  title_edit.text.toString(),
                                  author_edit.text.toString(),
                                  editorial_edit.text.toString(),
                                  cover_edit.text.toString(),
                                  pages_edit.text.toString().toInt(),
                                  year_edit.text.toString().toInt(),
                                  review_edit.toString(),
                                  topic_edit.toString())
            viewModel.books.value = new

            val action = new_bookDirections.actionNewBookToListFragment()
            v.findNavController().navigate(action)
        }
    }

}
