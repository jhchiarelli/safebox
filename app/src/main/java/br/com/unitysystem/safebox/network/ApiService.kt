package br.com.unitysystem.safebox.network

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body

import retrofit2.http.POST

interface ApiService {

    @POST("URL")
    fun auth(@Body requestBody: RequestBody) : Call<ResponseBody>

    @POST("URL")
    fun addItem(@Body requestBody: RequestBody) : Call<ResponseBody>

}