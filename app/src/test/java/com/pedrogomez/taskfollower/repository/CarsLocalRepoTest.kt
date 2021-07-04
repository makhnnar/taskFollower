package com.pedrogomez.taskfollower.repository

import androidx.lifecycle.LiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.pedrogomez.taskfollower.domian.db.Activity
import com.pedrogomez.taskfollower.domian.db.DailyTime
import com.pedrogomez.taskfollower.domian.db.SessionTime
import com.pedrogomez.taskfollower.domian.mapper.MapperContract
import com.pedrogomez.taskfollower.domian.view.CarModel
import com.pedrogomez.taskfollower.utils.DataHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


import org.junit.After

@RunWith(AndroidJUnit4::class)
class CarsLocalRepoTest {

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    lateinit var SUT: CarsLocalRepo

    var carsDaoTD = ActivityDaoTD()

    var mapperContractTD = MapperContractTD()

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
        SUT = CarsLocalRepo(
            carsDaoTD,
            mapperContractTD
        )
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

    @Test
    fun addCarSuccesPassedToDao() {
        runBlocking {
            launch(Dispatchers.Main) {
                SUT.addCar(
                    DataHelper.carView
                )
                assert(carsDaoTD.activity==DataHelper.carDB)
                assert(carsDaoTD.sessionTime==DataHelper.valueDB)
            }
        }
    }

    @Test
    fun updateCarSuccesPassedToDao() {
        runBlocking {
            launch(Dispatchers.Main) {
                SUT.updateCar(
                    DataHelper.carView
                )
                assert(carsDaoTD.activity==DataHelper.carDB)
                assert(carsDaoTD.sessionTime==DataHelper.valueDB)
            }
        }
    }

    @Test
    fun addCategorySuccesPassedToDao() {
        runBlocking {
            launch(Dispatchers.Main) {
                SUT.addCategory(
                    DataHelper.categoryDB
                )
                assert(carsDaoTD.dailyTime==DataHelper.categoryDB)
            }
        }
    }

    @Test
    fun getAllCategoriesSuccesFromDao() {
        runBlocking {
            launch(Dispatchers.Main) {
                var categoriesListLD = SUT.getCategories()
                assert(categoriesListLD==DataHelper.categoriesListLD)
            }
        }
    }

    @Test
    fun getAllCarsSuccesFromDao() {
        runBlocking {
            launch(Dispatchers.Main) {
                var carsListLD = SUT.getCars()
                assert(carsListLD==DataHelper.carsListLD)
            }
        }
    }

    class ActivityDaoTD : ActivityDao {

        var sessionTime: SessionTime? =null

        var dailyTime: DailyTime? =null

        var activity: Activity? = null

        override suspend fun insertNewCategory(
                dailyTime: DailyTime
        ): Long {
            this.dailyTime = dailyTime
            return 1
        }

        override suspend fun insertNewValue(
                sessionTime: SessionTime
        ): Long {
            this.sessionTime = sessionTime
            return 1
        }

        override suspend fun insertNewCar(activity: Activity): Long {
            this.activity = activity
            return 1
        }

        override suspend fun updateValue(sessionTime: SessionTime) {
            this.sessionTime = sessionTime
        }

        override suspend fun updateCar(activity: Activity) {
            this.activity = activity
        }

        override fun getAllCars(): LiveData<List<CarModel>> {
            return DataHelper.carsListLD
        }

        override fun getAllCategories(): LiveData<List<DailyTime>> {
            return DataHelper.categoriesListLD
        }

    }

    class MapperContractTD : MapperContract {

        override fun getCarAsModelForDB(carModel: CarModel): Activity {
            return DataHelper.carDB
        }

        override fun getValueAsModelForDB(carModel: CarModel): SessionTime? {
            return DataHelper.valueDB
        }

    }

}




