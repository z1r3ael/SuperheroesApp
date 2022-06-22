package com.example.week8superherociceroneappwb.modelPOJO

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Connections(
    @SerializedName("groupAffiliation")
    @Expose
    var groupAffiliation: String,
    @SerializedName("relatives")
    @Expose
    val relatives: String,
) : Parcelable