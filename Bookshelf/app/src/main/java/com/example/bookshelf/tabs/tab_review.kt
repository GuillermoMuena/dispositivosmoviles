package com.example.bookshelf.tabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.example.bookshelf.R
import com.example.bookshelf.viewmodels.bookDetailsViewModel

class tab_review : Fragment() {

    lateinit var resena : TextView
    lateinit var v :View

    private lateinit var viewModel : bookDetailsViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v =  inflater.inflate(R.layout.fragment_tab_review, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(bookDetailsViewModel::class.java)

        resena = v.findViewById(R.id.resena)

        viewModel.books.observe(viewLifecycleOwner, Observer { result ->
            resena.text = result.review
        })

        return v
    }
}
