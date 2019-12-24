package com.example.foodorderapp.network

import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.*

@JvmSuppressWildcards
interface ApiService {

    @Multipart
    @POST("/v2/login")
    fun login(): Observable<ApiResponse>
}