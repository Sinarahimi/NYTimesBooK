package ir.sinarahimi.data.repository.book

import ir.sinarahimi.data.datasource.book.BookLocalDataSource
import ir.sinarahimi.data.datasource.book.BookRemoteDataSource
import ir.sinarahimi.domain.ModelNYTimes
import ir.sinarahimi.domain.NetworkResponse
import ir.sinarahimi.domain.onSuccess
import ir.sinarahimi.domain.repository.book.BookRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by Sina Rahimi on 2/13/2021.
 */
class BookRepositoryImp(
    private val bookLocalDataSource: BookLocalDataSource,
    private val bookRemoteDataSource: BookRemoteDataSource
) : BookRepository {

    override suspend fun refresh(): NetworkResponse<List<ModelNYTimes.Book>> {
        return bookRemoteDataSource.get().onSuccess {
            bookLocalDataSource.persist(it)
            println("List")
        }
    }

    override fun get(): Flow<List<ModelNYTimes.Book>> {
        return bookLocalDataSource.fetch()
    }
}