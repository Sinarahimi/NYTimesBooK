package ir.sinarahimi.persistence.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.sinarahimi.persistence.database.Table

/**
 * Created by Sina Rahimi on 2/15/2021.
 */

@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBooks(books: List<Table.Book>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBuyLinks(buyLinks: List<Table.BuyLink>)

    //TODO start here
//    @Query("SELECT * FROM book")
//    fun
}