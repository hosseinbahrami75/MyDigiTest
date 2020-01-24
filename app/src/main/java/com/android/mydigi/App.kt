package com.android.mydigi

import android.app.Application
import com.android.mydigi.di.components.AppComponents
import com.android.mydigi.di.components.DaggerAppComponents
import com.android.mydigi.di.modules.AppModule
import com.android.mydigi.di.modules.NetModule

class App: Application() {

    val appComponent: AppComponents by lazy {
        DaggerAppComponents.builder()
            .appModule(AppModule(this))
            .netModule(NetModule())
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }

    companion object {
        @get:Synchronized
        lateinit var application: App
    }

}