package com.trubinov.shipperinfo.presentation.ui.base

import androidx.fragment.app.Fragment
import com.badoo.mvicore.binder.Binder

abstract class BaseBinding<F : Fragment>(fragment: F) {
    protected val binder = Binder()

    abstract fun setup(fragment: F)
}