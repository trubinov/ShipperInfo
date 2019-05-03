package com.trubinov.shipperinfo.presentation.di

import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import toothpick.config.Module

class RouteModule : Module() {
    init {
        val router = Router()
        val cicerone = Cicerone.create(router)
        bind(Router::class.java).toInstance(router)
        bind(Cicerone::class.java).toInstance(cicerone)
    }
}