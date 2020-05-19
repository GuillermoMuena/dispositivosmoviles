package com.example.bookshelf.fragments

import android.os.Bundle
import android.view.*
import android.widget.EditText
import androidx.fragment.app.Fragment
import android.widget.ImageButton
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.SearchView
import com.example.bookshelf.R
import com.example.bookshelf.adapters.book_list_adapter
import com.example.bookshelf.classes.Book
import com.example.bookshelf.database.bookDao
import com.example.bookshelf.database.bookDatabase
import com.example.bookshelf.viewmodels.bookViewModel
import androidx.lifecycle.Observer
import com.example.bookshelf.viewmodels.bookDetailsViewModel


class listFragment : Fragment() {

    lateinit var v : View
    lateinit var new_book_btn : ImageButton
    lateinit var reload_book_btn : ImageButton

    private var datab: bookDatabase? = null
    private var book_dao: bookDao? = null

    lateinit var recBooks : RecyclerView

    var listBooks : MutableList<Book> = ArrayList ()
    var displayListBooks : MutableList<Book> = ArrayList ()

    private lateinit var viewModel: bookViewModel
    private lateinit var viewDetailModel : bookDetailsViewModel


    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var bookListAdapter: book_list_adapter

    companion object {
        fun newInstance() = listFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_list_fragment, container, false)
        new_book_btn = v.findViewById(R.id.fab_add)
        reload_book_btn = v.findViewById(R.id.fab_reload)
        recBooks = v.findViewById(R.id.list_books)

        datab = bookDatabase.getAppDataBase(v.context)
        book_dao = datab?.bookDao()

        listBooks = book_dao?.loadAllBooks() as MutableList<Book>

        displayListBooks.addAll(listBooks)

        recBooks.setHasFixedSize(true)

        linearLayoutManager = LinearLayoutManager(context)
        recBooks.layoutManager = linearLayoutManager

        bookListAdapter = book_list_adapter(displayListBooks, this::onItemClick)
        recBooks.adapter = bookListAdapter

        setHasOptionsMenu(true)

        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        datab = bookDatabase.getAppDataBase(v.context)
        book_dao = datab?.bookDao()

        viewModel = ViewModelProvider(requireActivity()).get(bookViewModel::class.java)
        viewModel.books.observe(viewLifecycleOwner, Observer { result ->

            book_dao?.insertBook(Book(result.ISBN, result.title, result.author, result.editorial, result.cover, result.pages, result.year, result.review, result.topic))
        })
        listBooks.clear()
        listBooks = book_dao?.loadAllBooks() as MutableList<Book>
        displayListBooks.clear()
        displayListBooks.addAll(listBooks)
        bookListAdapter.notifyDataSetChanged()
    }

    override fun onStart() {
        super.onStart()

        new_book_btn.setOnClickListener {
            val action = listFragmentDirections.actionListFragmentToNewBook()
            v.findNavController().navigate(action)
        }

        reload_book_btn.setOnClickListener {
            val action = listFragmentDirections.actionListFragmentSelf()
            v.findNavController().navigate(action)
        }
    }

    public fun onItemClick (book: Book){
        viewDetailModel = ViewModelProvider(requireActivity()).get(bookDetailsViewModel::class.java)
        viewDetailModel.books.value = book
        val action = listFragmentDirections.actionListFragmentToNewBookFragmentContainer()
        v.findNavController().navigate(action)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_searc,menu)
        val searchItem = menu.findItem(R.id.action_search)
        if(searchItem != null){
            val searchView = searchItem.actionView as SearchView
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if(newText!!.isNotEmpty()){

                        displayListBooks.clear()
                        val search  = newText.toLowerCase()
                        listBooks.forEach{
                            if (it.title.toLowerCase().contains(search)){
                                displayListBooks.add(it)
                            }
                        }
                        bookListAdapter.notifyDataSetChanged()

                    }else{
                        displayListBooks.clear()
                        displayListBooks.addAll(listBooks)
                        bookListAdapter.notifyDataSetChanged()
                    }
                    return true
                }
            })
        }

        super.onCreateOptionsMenu(menu,inflater)
    }


}
