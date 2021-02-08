package ir.sinarahimi.network.api

import retrofit2.http.GET

/**
 * Created by Sina Rahimi on 2/8/2021.
 */
interface BookApi {

    //TODO start From here
    @GET("/reviews.json?author=Stephen+King&api-key=yourkey")
    suspend fun getBooks()
}