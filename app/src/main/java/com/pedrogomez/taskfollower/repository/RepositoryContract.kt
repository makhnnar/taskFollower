package com.pedrogomez.taskfollower.repository

import androidx.lifecycle.LiveData
import com.pedrogomez.taskfollower.domian.db.DailyTime
import com.pedrogomez.taskfollower.domian.view.CarModel

interface RepositoryContract {

    suspend fun addCar(carModel: CarModel)

    suspend fun updateCar(carModel: CarModel)

    fun getCars() : LiveData<List<CarModel>>

    suspend fun addCategory(dailyTime: DailyTime)

    fun getCategories() : LiveData<List<DailyTime>>

}