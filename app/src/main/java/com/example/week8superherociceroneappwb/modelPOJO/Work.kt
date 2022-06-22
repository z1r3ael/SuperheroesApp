package com.example.week8superherociceroneappwb.modelPOJO

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Work(
    @SerializedName("occupation")
    @Expose
    var occupation: String,
    @SerializedName("base")
    @Expose
    val base: String,
) : Parcelable