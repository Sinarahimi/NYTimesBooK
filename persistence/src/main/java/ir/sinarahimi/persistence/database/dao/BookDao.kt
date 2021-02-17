package ir.sinarahimi.persistence.database.dao

import androidx.room.*
import ir.sinarahimi.persistence.database.Table
import kotlinx.coroutines.flow.Flow

/**
 * Created by Sina Rahimi on 2/15/2021.
 */

@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBooks(books: List<Table.Book>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBuyLinks(buyLinks: List<Table.BuyLink>)

    @Transaction
    suspend fun insert(
        books: List<Table.Book>,
        buyLinks: List<Table.BuyLink>
    ) {
        insertBooks(books)
        insertBuyLinks(buyLinks)
    }

    @Transaction
    @Query("SELECT * FROM book")
    fun select(): Flow<List<BookAndBuyLinks>>
}

data class BookAndBuyLinks(
    @Embedded val book: Table.Book,
    @Relation (
        parentColumn = "title",
        entityColumn = "book_title"
    )
    val buyLinks: List<Table.BuyLink>
)