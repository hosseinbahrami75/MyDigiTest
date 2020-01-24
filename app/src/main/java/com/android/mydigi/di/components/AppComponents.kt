package com.android.mydigi.di.components

import com.android.mydigi.di.modules.AppModule
import com.android.mydigi.di.modules.NetModule
import com.android.mydigi.utils.BaseActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetModule::class])
interface AppComponents {
    fun inject(activity: BaseActivity)
}