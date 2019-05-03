package com.trubinov.shipperinfo.data.network

import com.trubinov.shipperinfo.data.network.model.InfoResponse
import io.reactivex.Single
import retrofit2.http.GET

interface Api {

    @GET("info")
    fun info(): Single<InfoResponse>

}