package com.trubinov.shipperinfo.app.di

import com.trubinov.shipperinfo.data.InfoImpl
import com.trubinov.shipperinfo.data.network.RetrofitClient
import com.trubinov.shipperinfo.domain.InfoRepository
import toothpick.config.Module

class DataModule: Module() {
    init {
        val retrofitClient = RetrofitClient()
        bind(InfoRepository::class.java).toInstance(InfoImpl(retrofitClient.getApi()))
    }
}