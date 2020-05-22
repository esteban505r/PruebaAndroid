package com.umb.pruebaandroid.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.umb.pruebaandroid.R
import com.umb.pruebaandroid.databinding.CardViewBinding
import com.umb.pruebaandroid.model.Datum
import java.lang.Exception

class ProductosRecyclerViewAdapter(var list:List<Datum>,var onClickListener: OnClickListener,val context: Context): RecyclerView.Adapter<ProductosRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(val binding: CardViewBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding:CardViewBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.card_view,parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.name.text = limitString(list[position].nombre,30)
        holder.binding.description.text = limitString(list[position].descripcion,229)
        holder.binding.price.text = limitString(list[position].precio,10)
        Picasso.get().load(list[position].imagen).into(holder.binding.imageView,object:Callback{
            override fun onSuccess() {

            }

            override fun onError(e: Exception?) {
                holder.binding.imageView.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.error))
            }

        })
        holder.binding.root.setOnClickListener{
            onClickListener.onClick(list[position])
        }
    }

    private fun limitString(string:String?, value:Int):String?{
        if(string?.length!!>value) {
            return string.substring(0, value) + "..."
        }
        else return string
    }
    interface OnClickListener{
        fun onClick(datum:Datum)
    }

    fun setData(list:List<Datum>){
        this.list = list
        notifyDataSetChanged()
    }
}