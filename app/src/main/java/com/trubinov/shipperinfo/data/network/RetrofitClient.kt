package com.trubinov.shipperinfo.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {
    private val mApi: Api

    init {
        val okHttpClient = OkHttpClient()
            .newBuilder().addInterceptor {
                val original = it.request()
                val request = original.newBuilder()
                    .header("Content-Type", "application/json")
                    .method(original.method(), original.body())
                    .build()
                it.proceed(request)
            }.readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .build()

        mApi = Retrofit.Builder()
            .baseUrl(URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

    fun getApi() = mApi

    companion object {
        private const val TIMEOUT = 30L
        private const val URL = "https://cargo-api.b2b-logist.com/"
    }
}