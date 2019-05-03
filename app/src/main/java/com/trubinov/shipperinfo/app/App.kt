package com.trubinov.shipperinfo.app

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.trubinov.shipperinfo.app.di.AppModule
import com.trubinov.shipperinfo.app.di.DataModule
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import toothpick.Toothpick
import toothpick.configuration.Configuration
import toothpick.smoothie.module.SmoothieApplicationModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        mContext = this
        mCicerone = Cicerone.create()
        // Toothpick
        Toothpick.setConfiguration(Configuration.forProduction())
        Toothpick.openScope(this.javaClass.canonicalName)
            .installModules(SmoothieApplicationModule(this),
                AppModule(this),
                DataModule())
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        private lateinit var mContext: Context

        private lateinit var mCicerone: Cicerone<Router>

        fun getContext() = mContext

        fun getRouter(): Router = mCicerone.router

        fun getNavigatorHolder(): NavigatorHolder = mCicerone.navigatorHolder
    }
}