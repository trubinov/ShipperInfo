package com.trubinov.shipperinfo.presentation.ui.main

import com.trubinov.shipperinfo.presentation.ui.base.BaseUIEvent

sealed class MainUIEvent : BaseUIEvent {
    object OnStart : MainUIEvent()
}