package ir.sinarahimi.network.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by Sina Rahimi on 2/8/2021.
 */
sealed class Dto {

    @JsonClass(generateAdapter = true)
    data class BaseNetworkResponse<T>(
        @Json(name = "status") val status: String,
        @Json(name = "results") val results: T

    ) : Dto()

    @JsonClass(generateAdapter = true)
    data class BooksResult(
        @Json(name = "books") val books: List<Book>

    ) : Dto()

    @JsonClass(generateAdapter = true)
    data class Book(
        @Json(name = "publisher") val publisher: String,
        @Json(name = "description") val description: String,
        @Json(name = "author") val author: String,
        @Json(name = "title") val title: String,
        @Json(name = "book_image") val bookImage: String,
        @Json(name = "buy_links") val buyLinks: List<Buy>
    ) : Dto()

    @JsonClass(generateAdapter = true)
    data class Buy(
        @Json(name = "name") val name: String,
        @Json(name = "url") val url: String
    ) : Dto()
}