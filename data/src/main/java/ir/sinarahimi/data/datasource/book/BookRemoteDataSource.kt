package ir.sinarahimi.data.datasource.book

import ir.sinarahimi.data.datasource.base.RemoteDataSource
import ir.sinarahimi.domain.ModelNYTimes
import ir.sinarahimi.domain.NetworkResponse

/**
 * Created by Sina Rahimi on 2/10/2021.
 */
interface BookRemoteDataSource : RemoteDataSource<ModelNYTimes.Book> {

    suspend fun get(): NetworkResponse<List<ModelNYTimes.Book>>
}