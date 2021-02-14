package ir.sinarahimi.network.datasource


import ir.sinarahimi.data.datasource.book.BookRemoteDataSource
import ir.sinarahimi.domain.ModelNYTimes
import ir.sinarahimi.domain.NetworkResponse
import ir.sinarahimi.domain.map
import ir.sinarahimi.network.BuildConfig
import ir.sinarahimi.network.api.BookApi
import ir.sinarahimi.network.execute
import ir.sinarahimi.network.mapper.dtoToModel

/**
 * Created by Sina Rahimi on 2/10/2021.
 */
class BookRemoteDataSourceImp(private val bookApi: BookApi) : BookRemoteDataSource {

    private val apiKey = BuildConfig.API_KEY

    //TODO Ask this
    override suspend fun get(): NetworkResponse<List<ModelNYTimes.Book>> = execute {

        bookApi.getBooks(apiKey)
    }.map {

        it.results.map { book ->

            book.dtoToModel()
        }
    }

}