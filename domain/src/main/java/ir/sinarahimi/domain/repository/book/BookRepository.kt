package ir.sinarahimi.domain.repository.book

import ir.sinarahimi.domain.ModelNYTimes
import ir.sinarahimi.domain.NetworkResponse
import ir.sinarahimi.domain.repository.base.BaseRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by Sina Rahimi on 2/13/2021.
 */
interface BookRepository : BaseRepository<ModelNYTimes.Book> {

    suspend fun refresh(): NetworkResponse<List<ModelNYTimes.Book>>

    fun get(): Flow<List<ModelNYTimes.Book>>
}