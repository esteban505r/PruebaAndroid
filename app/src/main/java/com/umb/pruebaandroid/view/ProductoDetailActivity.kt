package com.umb.pruebaandroid.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.umb.pruebaandroid.R
import com.umb.pruebaandroid.databinding.ProductoDetailActivityBinding
import com.umb.pruebaandroid.model.Datum
import java.lang.Exception

class ProductoDetailActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ProductoDetailActivityBinding = DataBindingUtil.setContentView(this, R.layout.producto_detail_activity)
        val item:Datum = intent.getSerializableExtra("producto") as Datum
        Picasso.get().load(item.imagen).into(binding.imageView,object: Callback {
            override fun onSuccess() {

            }

            override fun onError(e: Exception?) {
                binding.imageView.setImageDrawable(ContextCompat.getDrawable(this@ProductoDetailActivity,R.drawable.error))
            }

        })
        binding.producto = item
    }
}