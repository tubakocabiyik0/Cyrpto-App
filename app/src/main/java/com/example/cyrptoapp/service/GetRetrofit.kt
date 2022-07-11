package com.example.cyrptoapp.service

import com.example.cyrptoapp.utils.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetRetrofit {
 fun getRetrofitInstance() : RetrofitApi {
  val retrofit:Retrofit
  retrofit=Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
  return retrofit.create(RetrofitApi::class.java)
 }
}