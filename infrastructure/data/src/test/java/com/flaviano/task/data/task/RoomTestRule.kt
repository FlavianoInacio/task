@file:Suppress("MemberVisibilityCanBePrivate")

package com.flaviano.task.data.task

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module
import java.util.concurrent.Executors

class RoomTestRule : TestWatcher(), KoinComponent {

    private val roomOverrideModule: Module
        get() = module {
            single {
                Room.inMemoryDatabaseBuilder(
                    ApplicationProvider.getApplicationContext(),
                    com.flaviano.task.data.database.Database::class.java
                ).setTransactionExecutor(Executors.newSingleThreadExecutor())
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration().addTypeConverter(com.flaviano.task.data.database.converter.EnumTypeConverter())
                    .addTypeConverter(com.flaviano.task.data.database.converter.DateConverter())
                    .build()
            }
        }

    var database: com.flaviano.task.data.database.Database? = null

    override fun starting(description: Description) {
        closeExistingInstance()
        loadKoinModules(roomOverrideModule)
        database = inject<com.flaviano.task.data.database.Database>().value
    }

    override fun finished(description: Description) {
        closeExistingInstance()
    }

    private fun closeExistingInstance() {
        val currentDatabaseInstance = database
        try {
            if (currentDatabaseInstance != null && currentDatabaseInstance.isOpen) {
                currentDatabaseInstance.clearAllTables()
                currentDatabaseInstance.close()
            }
            database = null
            unloadKoinModules(roomOverrideModule)
        } catch (_: Exception) {
        }
    }

    companion object {
        fun create(): RoomTestRule {
            return RoomTestRule()
        }
    }
}