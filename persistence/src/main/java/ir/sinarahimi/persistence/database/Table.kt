package ir.sinarahimi.persistence.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Sina Rahimi on 2/15/2021.
 */
sealed class Table {

    @Entity(tableName = "book")
    data class Book(
        @ColumnInfo(name = "title") @PrimaryKey val title: String,
        @ColumnInfo(name = "publisher") val publisher: String,
        @ColumnInfo(name = "description") val description: String,
        @ColumnInfo(name = "author") val author: String,
        @ColumnInfo(name = "book_image") val bookImage: String,
    ) : Table()

    @Entity(tableName = "buy")
    data class BuyLink(
        @ColumnInfo(name = "book_title") @PrimaryKey val bookTitle: String,
        @ColumnInfo(name = "name") val name: String,
        @ColumnInfo(name = "url") val url: String
    ) : Table()
}