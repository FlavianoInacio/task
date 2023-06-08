package com.flaviano.task.data.di

import com.flaviano.task.data.database.Database
import com.flaviano.task.data.task.TaskRepository
import com.flaviano.task.data.task.TaskRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

object DataModule {

    val modules: Module
        get() = module {
            single {
                Database.instance(context = androidContext())
            }
            single { get<Database>().taskDao }
            single { com.flaviano.task.data.task.datasource.TaskLocalDataSource(taskDao = get()) }
            single<TaskRepository> {
                TaskRepositoryImpl(
                    taskLocalDataSource = get()
                )
            }
        }
}