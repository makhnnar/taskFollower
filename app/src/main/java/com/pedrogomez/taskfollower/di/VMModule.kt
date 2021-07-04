package com.pedrogomez.taskfollower.di

import com.pedrogomez.taskfollower.presentation.CarsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelInstance = module {
    viewModel {
        CarsViewModel(
            get()
        )
    }
}