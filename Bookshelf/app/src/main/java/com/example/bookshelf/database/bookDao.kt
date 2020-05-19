package com.example.bookshelf.database

import androidx.room.*
import com.example.bookshelf.classes.Book


@Dao
public interface bookDao {

    @Query("SELECT * FROM books ORDER BY title")
    fun loadAllBooks(): MutableList<Book?>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBook(books: Book?)

    @Update
    fun updateBook(books: Book?)

    @Delete
    fun delete(books: Book?)

    @Query("SELECT * FROM books WHERE ISBN = :ISBN")
    fun loadBookByISBN(ISBN: String): Book

}