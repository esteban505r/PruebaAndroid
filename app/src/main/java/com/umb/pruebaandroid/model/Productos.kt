package com.umb.pruebaandroid.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Productos {
    @SerializedName("code")
    @Expose
    var code: String? = null

    @SerializedName("data")
    @Expose
    var data: List<Datum>? = null

}