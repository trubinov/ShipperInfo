package com.trubinov.shipperinfo.presentation.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trubinov.shipperinfo.R
import com.trubinov.shipperinfo.presentation.ui.base.BaseFragment
import javax.inject.Inject

class MainFragment : BaseFragment<MainUIEvent, MainViewModel, MainModule>() {

    @Inject
    lateinit var mBinding: MainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.setup(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onStart() {
        super.onStart()
        onNext(MainUIEvent.OnStart)
    }

}