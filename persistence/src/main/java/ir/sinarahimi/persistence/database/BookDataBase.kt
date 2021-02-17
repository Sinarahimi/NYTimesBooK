package ir.sinarahimi.persistence.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.sinarahimi.persistence.database.dao.BookDao

/**
 * Created by Sina Rahimi on 2/17/2021.
 */
@Database(
    entities = [
        Table.Book::class,
        Table.BuyLink::class
    ],
    version = 1
)
abstract class BookDataBase : RoomDatabase() {

    abstract fun bookDao(): BookDao
}