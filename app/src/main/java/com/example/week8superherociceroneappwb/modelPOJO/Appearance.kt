package com.example.week8superherociceroneappwb.modelPOJO

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Appearance(
    @SerializedName("gender")
    @Expose
    var gender: String,
    @SerializedName("race")
    @Expose
    val race: String?,
    @SerializedName("height")
    @Expose
    val height: List<String>,
    @SerializedName("weight")
    @Expose
    val weight: List<String>,
    @SerializedName("eyeColor")
    @Expose
    val eyeColor: String,
    @SerializedName("hairColor")
    @Expose
    val hairColor: String,
) : Parcelable