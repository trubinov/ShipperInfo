package com.trubinov.shipperinfo.presentation.ui.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.trubinov.shipperinfo.app.App
import com.trubinov.shipperinfo.presentation.MainActivity
import io.reactivex.ObservableSource
import io.reactivex.Observer
import io.reactivex.functions.Consumer
import io.reactivex.subjects.BehaviorSubject
import toothpick.Toothpick
import toothpick.config.Module
import kotlin.reflect.KClass

abstract class BaseFragment<E : BaseUIEvent, VM : BaseViewModel, out M : Module> : Fragment(), ObservableSource<E>, Consumer<VM> {

    private val mSource = BehaviorSubject.create<E>()

    override fun subscribe(observer: Observer<in E>) {
        mSource.subscribe(observer)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        Toothpick.openScopes(App::class.java.canonicalName, MainActivity::class.java.canonicalName, this.javaClass.canonicalName).let {
            @Suppress("UNCHECKED_CAST")
            val module = (this::class.supertypes[0].arguments[2].type!!.classifier as KClass<M>).constructors.iterator().next().call(this)
            it.installModules(module)
            Toothpick.inject(this, it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Toothpick.closeScope(this.javaClass.canonicalName)
    }

    protected fun onNext(event: E) {
        mSource.onNext(event)
    }

    override fun accept(t: VM) {

    }

}