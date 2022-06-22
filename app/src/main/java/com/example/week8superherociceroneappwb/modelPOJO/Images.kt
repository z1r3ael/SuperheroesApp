package com.example.week8superherociceroneappwb.modelPOJO

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Images(
    @SerializedName("xs")
    @Expose
    var xs: String,
    @SerializedName("sm")
    @Expose
    val sm: String,
    @SerializedName("md")
    @Expose
    val md: String,
    @SerializedName("lg")
    @Expose
    val lg: String,
) : Parcelable