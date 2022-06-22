package com.example.week8superherociceroneappwb.modelPOJO

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Biography(
    @SerializedName("fullName")
    @Expose
    var fullName: String,
    @SerializedName("alterEgos")
    @Expose
    val alterEgos: String,
    @SerializedName("aliases")
    @Expose
    val aliases: List<String>,
    @SerializedName("placeOfBirth")
    @Expose
    val placeOfBirth: String,
    @SerializedName("firstAppearance")
    @Expose
    val firstAppearance: String,
    @SerializedName("publisher")
    @Expose
    val publisher: String?,
    @SerializedName("alignment")
    @Expose
    val alignment: String,
) : Parcelable