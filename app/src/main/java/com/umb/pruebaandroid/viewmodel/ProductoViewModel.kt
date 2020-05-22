package com.umb.pruebaandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.umb.pruebaandroid.model.Datum
import com.umb.pruebaandroid.model.ProductosRepository

class ProductoViewModel:ViewModel() {

    var repository:ProductosRepository? = null

    fun provideRepository():ProductosRepository?{
        if(repository!=null){
            return repository
        }
        else{
            repository = ProductosRepository()
            return repository
        }
    }

    fun getProductos(): LiveData<List<Datum>>{
        return provideRepository()!!.getProductos()
    }
}