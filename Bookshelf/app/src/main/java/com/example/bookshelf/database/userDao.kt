package com.example.bookshelf.database

import androidx.room.*
import com.example.bookshelf.classes.User


@Dao
public interface userDao {

    @Query("SELECT * FROM users ORDER BY email")
    fun loadAllPersons(): MutableList<User?>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPerson(user: User?)

    @Update
    fun updatePerson(user: User?)

    @Delete
    fun delete(user: User?)

    @Query("SELECT * FROM users WHERE name = :name")
    fun loadPersonByName(name: String): User?

}