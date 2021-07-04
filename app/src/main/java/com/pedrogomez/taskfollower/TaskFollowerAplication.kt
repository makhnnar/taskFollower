package com.pedrogomez.taskfollower

import android.app.Application
import com.pedrogomez.taskfollower.di.carsRepository
import com.pedrogomez.taskfollower.di.dbInstance
import com.pedrogomez.taskfollower.di.viewModelInstance
import com.pedrogomez.taskfollower.di.viewToDbMapper
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TaskFollowerAplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(
                this@TaskFollowerAplication
            )
            androidLogger()
            modules(
                listOf(
                    dbInstance,
                    viewToDbMapper,
                    carsRepository,
                    viewModelInstance
                )
            )
        }
    }

}