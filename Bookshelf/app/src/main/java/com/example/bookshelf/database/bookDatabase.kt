package com.example.bookshelf.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bookshelf.classes.Book


@Database(entities = [Book::class], version = 1, exportSchema = false)

public  abstract class bookDatabase : RoomDatabase() {

    abstract fun bookDao(): bookDao


    companion object {
        var INSTANCE: bookDatabase? = null

        fun getAppDataBase(context: Context): bookDatabase? {
            if (INSTANCE == null) {
                synchronized(bookDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        bookDatabase::class.java,
                        "myBookDB"
                    ).allowMainThreadQueries().build() // No es lo mas recomendable que se ejecute en el mainthread
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }
}