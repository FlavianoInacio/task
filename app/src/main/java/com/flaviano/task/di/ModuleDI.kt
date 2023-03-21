package com.flaviano.task.di

import com.flaviano.task.data.TaskLocalDataSource
import com.flaviano.task.data.TaskRepositoryImpl
import com.flaviano.task.database.Database
import com.flaviano.task.domain.TaskRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

object ModuleDI {

    val modules: Module
        get() = module {
            single {
                Database.instance(context = androidContext())
            }
            single { get<Database>().taskDao }
            single { TaskLocalDataSource(taskDao = get()) }
            single<TaskRepository> { TaskRepositoryImpl(taskLocalDataSource = get()) }
        }
}