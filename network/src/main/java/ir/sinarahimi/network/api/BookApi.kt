package ir.sinarahimi.network.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Sina Rahimi on 2/8/2021.
 */
interface BookApi {

    @GET("reviews.json?author=Stephen+King")
    suspend fun getBooks(@Query("api-key") apiKey: String):
            Response<Dto.BaseNetworkResponse<List<Dto.Book>>>
}