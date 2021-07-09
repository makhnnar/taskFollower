package com.pedrogomez.taskfollower.di

import androidx.room.Room
import com.pedrogomez.taskfollower.domian.db.TaskDBM
import com.pedrogomez.taskfollower.domian.mapper.MapperContract
import com.pedrogomez.taskfollower.domian.mapper.TaskModelMapper
import com.pedrogomez.taskfollower.domian.view.TaskVM
import com.pedrogomez.taskfollower.repository.TaskDB
import com.pedrogomez.taskfollower.repository.TaskLocalRepo
import com.pedrogomez.taskfollower.repository.RepositoryContract
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dbInstance = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            TaskDB::class.java,
            "taskRepository.db"
        ).build()
    }
}

val viewToDbMapper = module{
    single<MapperContract<TaskVM, TaskDBM>>{
        TaskModelMapper()
    }
}

val carsRepository = module{
    single<RepositoryContract>{
        TaskLocalRepo(
            get<TaskDB>().activities(),
            get()
        )
    }
}