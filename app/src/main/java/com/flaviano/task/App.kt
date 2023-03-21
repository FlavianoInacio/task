package com.flaviano.task

import android.app.Application
import com.flaviano.task.di.ModuleDI
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            ModuleDI.modules
        }
    }
}