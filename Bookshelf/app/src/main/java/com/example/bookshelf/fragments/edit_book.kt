package com.example.bookshelf.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.EditText
import android.widget.ImageButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController

import com.example.bookshelf.R
import com.example.bookshelf.classes.Book
import com.example.bookshelf.viewmodels.bookDetailsViewModel
import com.example.bookshelf.viewmodels.bookViewModel

class edit_book : Fragment() {
        companion object {
            fun newInstance() = edit_book()
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
        private lateinit var viewDetailModel : bookDetailsViewModel

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            v = inflater.inflate(R.layout.fragment_new_book, container, false)

            viewDetailModel = ViewModelProvider(requireActivity()).get(bookDetailsViewModel::class.java)

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

            viewDetailModel.books.observe(viewLifecycleOwner, Observer { result ->
                title_edit.setText(result.title)
                author_edit.setText(result.author)
                editorial_edit.setText(result.editorial)
                cover_edit.setText(result.cover)
                pages_edit.setText(result.pages.toString())
                year_edit.setText(result.year.toString())
                topic_edit.setText(result.topic)
                ISBN_edit.setText(result.ISBN)
                review_edit.setText(result.review)
            })


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
                val new : Book = Book(ISBN_edit.text.toString(),
                    title_edit.text.toString(),
                    author_edit.text.toString(),
                    editorial_edit.text.toString(),
                    cover_edit.text.toString(),
                    pages_edit.text.toString().toInt(),
                    year_edit.text.toString().toInt(),
                    review_edit.text.toString(),
                    topic_edit.text.toString())
                viewModel.books.value = new

                val action = edit_bookDirections.actionEditBookToListFragment()
                v.findNavController().navigate(action)
            }
        }

    }
