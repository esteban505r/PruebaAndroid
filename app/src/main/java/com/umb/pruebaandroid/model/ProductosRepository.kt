package com.umb.pruebaandroid.model

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductosRepository {

    private var productoApi:API = APIClient.getClient().create(API::class.java)

    fun getProductos():MutableLiveData<List<Datum>>{
        val productos:MutableLiveData<List<Datum>> = MutableLiveData()
        productoApi.getAll().enqueue(object: Callback<Productos> {
            override fun onResponse(call: Call<Productos>, response: Response<Productos>) {
                if(response.isSuccessful){
                    productos.value = response.body()?.data
                }
            }
            override fun onFailure(call: Call<Productos>, t: Throwable) {
                productos.value = null
            }
        })
        return productos
    }
}