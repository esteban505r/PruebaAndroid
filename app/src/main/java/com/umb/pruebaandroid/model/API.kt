package com.umb.pruebaandroid.model

import retrofit2.Call
import retrofit2.http.GET

interface API {

    @GET("0")
    fun getAll():Call<Productos>
}