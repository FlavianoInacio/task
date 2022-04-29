package com.flaviano.data.module.di

import com.flaviano.data.module.task.repository.TaskDataSource
import com.flaviano.data.module.task.repository.TaskRepositoryImpl
import com.flaviano.domain.task.repository.TaskRepository
import org.koin.dsl.module

val dataModule = module {

    // repository
    single<TaskRepository> { TaskRepositoryImpl(get()) }

    // dataSource
    single { TaskDataSource() }
}