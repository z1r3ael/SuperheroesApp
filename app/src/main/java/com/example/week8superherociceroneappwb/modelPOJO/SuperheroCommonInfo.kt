package com.example.week8superherociceroneappwb.modelPOJO

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SuperheroCommonInfo(
    @SerializedName("id")
    @Expose
    var id: Int,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("slug")
    @Expose
    val slug: String,
    @SerializedName("powerstats")
    @Expose
    val powerstats: Powerstats,
    @SerializedName("appearance")
    @Expose
    val appearance: Appearance,
    @SerializedName("biography")
    @Expose
    val biography: Biography,
    @SerializedName("work")
    @Expose
    val work: Work,
    @SerializedName("connections")
    @Expose
    val connections: Connections,
    @SerializedName("images")
    @Expose
    val images: Images,
) : Parcelable