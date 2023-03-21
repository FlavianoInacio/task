@file:Suppress("MemberVisibilityCanBePrivate")

package com.flaviano.task.data

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.flaviano.task.database.Database
import com.flaviano.task.database.converter.DateConverter
import com.flaviano.task.database.converter.EnumTypeConverter
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
                    Database::class.java
                ).setTransactionExecutor(Executors.newSingleThreadExecutor())
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration().addTypeConverter(EnumTypeConverter())
                    .addTypeConverter(DateConverter())
                    .build()
            }
        }

    var database: Database? = null

    override fun starting(description: Description) {
        closeExistingInstance()
        loadKoinModules(roomOverrideModule)
        database = inject<Database>().value
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