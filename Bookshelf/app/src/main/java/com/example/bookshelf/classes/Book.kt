/* CONSIDER ADDING FOR FUTURE VERSIONS      */
/* - Format of the book                     */
/* - Quantity available                     */
/* - Language                               */
/* - ISBN                                   */
/* - Backcover                              */
/* - Review                                 */
/* - Topics                                 */
/* - Type                                   */
/* - Web                                    */
/* - Make language selectable from a list   */
/* - Make a custom prompt to input ISBN     */
/* - Make a custom prompt to input a review */

package com.example.bookshelf.classes

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
class Book(ISBN: String,title: String,author: String,editorial: String,cover: String,pages: Int, year: Int, review : String, topic : String) {
    @PrimaryKey
    @ColumnInfo(name = "ISBN")
    var ISBN: String = ""

    @ColumnInfo(name = "title")
    var title: String = ""

    @ColumnInfo(name = "author")
    var author: String = ""

    @ColumnInfo(name = "editorial")
    var editorial: String = ""

    @ColumnInfo(name = "cover")
    var cover: String = ""

    @ColumnInfo(name = "review")
    var review : String = ""

    @ColumnInfo(name = "topic")
    var topic : String = ""


    @ColumnInfo(name = "pages")
    var pages: Int = 0

    @ColumnInfo(name = "year")
    var year: Int = 0


    init {
        this.ISBN = ISBN
        this.title = title
        this.author = author
        this.editorial = editorial
        this.cover = cover
        this.review = review
        this.topic = topic
        this.pages = pages
        this.year = year
    }

    fun set_ISBN (value : String)
    {
        this.ISBN = value
    }

    fun set_title (value : String)
    {
        this.title = value
    }

    fun set_author (value : String)
    {
        this.author = value
    }

    fun set_editorial (value : String)
    {
        this.editorial = value
    }

    fun set_cover (value : String)
    {
        this.cover = value
    }

    fun set_pages (value : Int)
    {
        this.pages = value
    }

    fun set_year (value : Int)
    {
        this.year = value
    }

    fun set_review (value : String)
    {
        this.review = value
    }

    fun set_topic (value : String)
    {
        this.topic = value
    }

}