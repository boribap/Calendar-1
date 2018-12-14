package com.bsww201.www.vasycalendar.api

import com.bsww201.www.vasycalendar.utils.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

// retrofit : API 설정을 위한 인터페이스
interface ServiceAPI {
    @POST("sign_up")
    fun signUpData(
            @Body user: User
    ): Call<List<ResponseJSON>>

    @POST("sign_in")
    fun loginData(
            @Body user:User
    ): Call<List<ResponseJSON>>

    @GET("calender")
    fun loginData(
            @Header("Authorization") access_token : String
    ): Call<ResponseJSON>
}