package ir.sinarahimi.network

import ir.sinarahimi.domain.NetworkResponse
import retrofit2.Response

/**
 * Created by Sina Rahimi on 2/14/2021.
 */
inline fun <T> execute(request: () -> Response<T>): NetworkResponse<T> =
    try {
        val response = request()
        if (response.isSuccessful) {
            NetworkResponse.Success(response.body()!!)
        } else {
            NetworkResponse.Failure(response.code())
        }
    } catch (ex: Exception) {
        NetworkResponse.Error(ex)
    }