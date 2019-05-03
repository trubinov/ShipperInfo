package com.trubinov.shipperinfo.presentation.ui.main

import toothpick.config.Module

class MainModule(fragment: MainFragment) : Module() {
    init {
        bind(MainFragment::class.java).toInstance(fragment)
    }
}