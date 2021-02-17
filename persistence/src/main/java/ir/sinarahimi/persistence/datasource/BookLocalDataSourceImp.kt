package ir.sinarahimi.persistence.datasource

import ir.sinarahimi.data.datasource.book.BookLocalDataSource
import ir.sinarahimi.domain.ModelNYTimes
import ir.sinarahimi.persistence.database.Table
import ir.sinarahimi.persistence.database.dao.BookDao
import ir.sinarahimi.persistence.mapper.mapToModel
import ir.sinarahimi.persistence.mapper.mapToTable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Created by Sina Rahimi on 2/17/2021.
 */
class BookLocalDataSourceImp(private val bookDao: BookDao) : BookLocalDataSource {

    override fun fetch(): Flow<List<ModelNYTimes.Book>> {
        return bookDao.select().map {
            it.map {
                it.mapToModel()
            }
        }
    }

    override suspend fun persist(books: List<ModelNYTimes.Book>) {
        val buyLinks = mutableListOf<Table.BuyLink>()

        books.forEach { book ->
            buyLinks.addAll(book.buyLinks.map { it.mapToTable(book.title) })
        }
        bookDao.insert(books.map { it.mapToTable() },buyLinks)
    }
}