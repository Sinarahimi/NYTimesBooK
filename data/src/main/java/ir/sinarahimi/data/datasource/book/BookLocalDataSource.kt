package ir.sinarahimi.data.datasource.book

import ir.sinarahimi.data.datasource.base.LocalDataSource
import ir.sinarahimi.domain.ModelNYTimes
import kotlinx.coroutines.flow.Flow

/**
 * Created by Sina Rahimi on 2/13/2021.
 */
interface BookLocalDataSource : LocalDataSource<ModelNYTimes.Book> {

    fun fetch(): Flow<List<ModelNYTimes.Book>>

    suspend fun persist(books: List<ModelNYTimes.Book>)
}