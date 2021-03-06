package com.yakov.weber.cleanapp.toothpick.module

import android.content.Context
import com.yakov.weber.cleanapp.model.system.message.SystemMessageNotifier
import com.yakov.weber.cleanapp.toothpick.system.ResManager
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import timber.log.Timber
import toothpick.config.Module

/**
 * Created on 09.10.18
 * @author YWeber
 * project CiceroneNavigation */

class AppModule (context:Context) : Module() {

    init {
        Timber.e("Common Inject")
        bind(Context::class.java).toInstance(context)
        bind(ResManager::class.java).singletonInScope()
        bind(SystemMessageNotifier::class.java).toInstance(SystemMessageNotifier())

        Timber.e("Navigation Inject")
        val cicerone = Cicerone.create()
        bind(Router::class.java).toInstance(cicerone.router)
        bind(NavigatorHolder::class.java).toInstance(cicerone.navigatorHolder)
    }

}