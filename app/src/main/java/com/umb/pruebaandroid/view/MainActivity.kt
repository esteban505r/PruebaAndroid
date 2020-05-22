package com.umb.pruebaandroid.view

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.umb.pruebaandroid.R
import com.umb.pruebaandroid.databinding.ActivityMainBinding
import com.umb.pruebaandroid.model.Datum
import com.umb.pruebaandroid.viewmodel.ProductoViewModel
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true

        if (!isConnected) {
            AlertDialog.Builder(this).setMessage("Debes estar conectado a internet")
                .setNeutralButton(
                    "Aceptar"
                ) { _, _ -> finish() }.setCancelable(false).show()
        } else {

            binding.button.setOnClickListener {
                val i: Intent = Intent(this, MapActivity::class.java)
                startActivity(i)
            }

            val viewModel: ProductoViewModel =
                ViewModelProvider(this).get(ProductoViewModel::class.java)
            binding.recyclerView.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.recyclerView.adapter = ProductosRecyclerViewAdapter(listOf(),
                object : ProductosRecyclerViewAdapter.OnClickListener {
                    override fun onClick(datum: Datum) {
                        val i = Intent(this@MainActivity, ProductoDetailActivity::class.java)
                        i.putExtra("producto", datum)
                        startActivity(i)
                        overridePendingTransition(R.anim.push_right_in, R.anim.push_right_in)
                    }

                }, this
            )
            val observer = Observer<List<Datum>> {
                (binding.recyclerView.adapter as ProductosRecyclerViewAdapter).setData(it)
            }
            viewModel.getProductos().observe(this, observer)
        }
    }
}


