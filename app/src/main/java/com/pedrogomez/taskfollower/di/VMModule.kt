package com.pedrogomez.taskfollower.di

import com.pedrogomez.taskfollower.view.list.presentation.TaskViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelInstance = module {
    viewModel {
        TaskViewModel(
            get()
        )
    }
}