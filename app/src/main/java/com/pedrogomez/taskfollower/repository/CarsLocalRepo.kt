package com.pedrogomez.taskfollower.repository

import androidx.lifecycle.LiveData
import com.pedrogomez.taskfollower.domian.db.DailyTime
import com.pedrogomez.taskfollower.domian.mapper.MapperContract
import com.pedrogomez.taskfollower.domian.view.CarModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class CarsLocalRepo(
        private val activityDao: ActivityDao,
        private val mapperContract: MapperContract,
        private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : RepositoryContract {

    override suspend fun addCar(carModel: CarModel) {
        activityDao.addCarWithValue(
                mapperContract.getCarAsModelForDB(carModel),
                mapperContract.getValueAsModelForDB(carModel)
        )
    }

    override suspend fun updateCar(carModel: CarModel) {
        activityDao.updateCarWithValue(
            mapperContract.getCarAsModelForDB(carModel),
            mapperContract.getValueAsModelForDB(carModel)
        )
    }

    override fun getCars(): LiveData<List<CarModel>> {
        return activityDao.getAllCars()
    }

    override suspend fun addCategory(dailyTime : DailyTime) {
        activityDao.insertNewCategory(dailyTime)
    }

    override fun getCategories(): LiveData<List<DailyTime>> {
        return activityDao.getAllCategories()
    }

}