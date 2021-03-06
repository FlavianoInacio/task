package com.flaviano.task_app

import android.app.Application
import com.flaviano.data.module.di.dataModule
import com.flaviano.desing_system._module.di.designSystemModule
import com.flaviano.domain._module.di.domainModule
import com.flaviano.task_app._module.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(androidContext = this@App)
            modules(
                listOf(
                    appModule,
                    domainModule,
                    dataModule,
                    designSystemModule
                )
            )
        }
    }
}