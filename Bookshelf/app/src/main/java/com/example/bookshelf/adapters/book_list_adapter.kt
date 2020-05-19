package com.example.bookshelf.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookshelf.R
import com.example.bookshelf.classes.Book
import kotlinx.android.synthetic.main.item_book_layout.view.*

class book_list_adapter (private var booksList: MutableList<Book>, val adapterOnClick : (Book) -> Unit) : RecyclerView.Adapter<book_list_adapter.BookHolder>() {

    companion object {

        private val TAG = "book_list_adapter"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_book_layout,parent,false)
        return (BookHolder(
            view
        ))
    }

    override fun onBindViewHolder(holder: BookHolder, position: Int) {

        holder.bind(booksList[position])
        holder.getCardLayout().setOnClickListener {
            adapterOnClick(booksList[position])
        }

    }

    class BookHolder (v: View) : RecyclerView.ViewHolder(v){

        private var view: View

        init {
            this.view = v
        }

        fun bind(book: Book){
            val title : TextView = view.findViewById(R.id.title)
            title.text = book.title
        }

        //fun set_title(title_val : String) {
        //    val title : TextView = view.findViewById(R.id.title)
        //    title.text = title_val
        //    view.setOnClickListener { listener(item) }
        //}

        fun getCardLayout (): CardView {

            return view.findViewById(R.id.card_package_item)
        }

    }

    override fun getItemCount(): Int {
       return booksList.size
    }


}