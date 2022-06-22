package com.example.week8superherociceroneappwb.modelPOJO

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Powerstats(
    @SerializedName("intelligence")
    @Expose
    var intelligence: Int,
    @SerializedName("strength")
    @Expose
    val strength: Int,
    @SerializedName("speed")
    @Expose
    val speed: Int,
    @SerializedName("durability")
    @Expose
    val durability: Int,
    @SerializedName("power")
    @Expose
    val power: Int,
    @SerializedName("combat")
    @Expose
    val combat: Int,
) : Parcelable