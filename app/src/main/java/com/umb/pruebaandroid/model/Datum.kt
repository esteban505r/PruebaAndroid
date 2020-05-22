package com.umb.pruebaandroid.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Datum : Serializable{
    @SerializedName("categoria")
    @Expose
    var categoria: String? = null

    @SerializedName("cliente")
    @Expose
    var cliente: String? = null

    @SerializedName("colores")
    @Expose
    var colores: String? = null

    @SerializedName("descripcion")
    @Expose
    var descripcion: String? = null

    @SerializedName("disponible")
    @Expose
    var disponible: String? = null

    @SerializedName("estado")
    @Expose
    var estado: String? = null

    @SerializedName("fecha_creacion")
    @Expose
    var fechaCreacion: String? = null

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("nombre")
    @Expose
    var nombre: String? = null

    @SerializedName("precio")
    @Expose
    var precio: String? = null

    @SerializedName("tallas")
    @Expose
    var tallas: String? = null

    @SerializedName("video")
    @Expose
    var video: String? = null

    @SerializedName("descripcion_promo")
    @Expose
    var descripcionPromo: String? = null

    @SerializedName("id_promocion")
    @Expose
    var idPromocion: String? = null

    @SerializedName("valor_promo")
    @Expose
    var valorPromo: String? = null

    @SerializedName("id_producto_promo")
    @Expose
    var idProductoPromo: String? = null

    @SerializedName("fecha_promo")
    @Expose
    var fechaPromo: String? = null

    @SerializedName("estado_promo")
    @Expose
    var estadoPromo: String? = null

    @SerializedName("likes")
    @Expose
    var likes: String? = null

    @SerializedName("megusta")
    @Expose
    var megusta: String? = null

    @SerializedName("galeria")
    @Expose
    var galeria: String? = null

    @SerializedName("imagen")
    @Expose
    var imagen: String? = null

}