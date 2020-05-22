package com.umb.pruebaandroid.model

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {

    companion object {
        val BASE_URL: String = "https://api.bazzaio.com/v5/listados/listar_productos_tienda/297/0/"
        var retrofit: Retrofit? = null

        fun getClient(): Retrofit {
            val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor();
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val okHttpClient: OkHttpClient =
                OkHttpClient.Builder().addInterceptor(interceptor).build()
            retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build()
            return retrofit as Retrofit
        }
    }
}