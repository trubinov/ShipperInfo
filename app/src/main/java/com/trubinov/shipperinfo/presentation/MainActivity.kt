package com.trubinov.shipperinfo.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.trubinov.shipperinfo.R
import com.trubinov.shipperinfo.app.App
import com.trubinov.shipperinfo.presentation.di.RouteModule
import com.trubinov.shipperinfo.presentation.ui.main.MainFragment
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import toothpick.Toothpick
import toothpick.smoothie.module.SmoothieAndroidXActivityModule
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mRouter: Router

    private var mNavigator: Navigator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toothpick.openScopes(App::class.java.canonicalName, this.javaClass.canonicalName).apply {
            installModules(
                SmoothieAndroidXActivityModule(this@MainActivity),
                RouteModule()
            )
            Toothpick.inject(this@MainActivity, this)
        }
        mNavigator = SupportAppNavigator(this, R.id.flMain)
        if (savedInstanceState == null) {
            //mRouter.newRootScreen(MainFragment::class.java.canonicalName)
        }
//        supportFragmentManager.registerFragmentLifecycleCallbacks(object : FragmentManager.FragmentLifecycleCallbacks() {
//            override fun onFragmentViewCreated(fm: FragmentManager, f: Fragment, v: View, savedInstanceState: Bundle?) {
//                super.onFragmentViewCreated(fm, f, v, savedInstanceState)
//            }
//        }, true)
    }
}
