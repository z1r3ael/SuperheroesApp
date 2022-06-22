package com.example.week8superherociceroneappwb.data

import com.example.week8superherociceroneappwb.modelPOJO.SuperheroCommonInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Streaming
import retrofit2.http.Url

interface MyAPICall {
    @GET
    @Streaming
    fun getSuperheroCommonInfo(@Url heroId: String): Call<SuperheroCommonInfo>
}