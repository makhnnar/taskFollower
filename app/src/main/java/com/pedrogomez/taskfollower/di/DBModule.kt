package com.pedrogomez.taskfollower.di

import androidx.room.Room
import com.pedrogomez.taskfollower.domian.mapper.MapperContract
import com.pedrogomez.taskfollower.domian.mapper.ViewToDBMapper
import com.pedrogomez.taskfollower.repository.ActivitiesDB
import com.pedrogomez.taskfollower.repository.CarsLocalRepo
import com.pedrogomez.taskfollower.repository.RepositoryContract
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dbInstance = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            ActivitiesDB::class.java,
            "carsStore.db"
        ).createFromAsset("database/categories.db")
            .build()
    }
}

val viewToDbMapper = module{
    single<MapperContract>{
        ViewToDBMapper()
    }
}

val carsRepository = module{
    single<RepositoryContract>{
        CarsLocalRepo(
            get<ActivitiesDB>().activities(),
            get()
        )
    }
}