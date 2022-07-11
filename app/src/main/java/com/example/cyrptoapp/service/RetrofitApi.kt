package com.example.cyrptoapp.service

import com.example.cyrptoapp.Model
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitApi {
    @GET("/atilsamancioglu/IA32-CryptoComposeData/main/cryptolist.json")
    suspend fun getData() : Response<List<Model>>

}