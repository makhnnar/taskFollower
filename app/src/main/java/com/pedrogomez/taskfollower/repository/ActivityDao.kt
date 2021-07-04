package com.pedrogomez.taskfollower.repository

import androidx.lifecycle.LiveData
import androidx.room.*
import com.pedrogomez.taskfollower.domian.db.Activity
import com.pedrogomez.taskfollower.domian.db.DailyTime
import com.pedrogomez.taskfollower.domian.db.SessionTime
import com.pedrogomez.taskfollower.domian.view.CarModel

@Dao
interface ActivityDao {

    @Insert
    suspend fun insertNewCategory(dailyTime: DailyTime) : Long

    @Insert
    suspend fun insertNewValue(sessionTime: SessionTime) : Long

    @Insert
    suspend fun insertNewCar(activity: Activity) : Long

    @Update
    suspend fun updateValue(sessionTime: SessionTime)

    @Update
    suspend fun updateCar(activity: Activity)

    @Transaction
    open suspend fun addCarWithValue(
            activity: Activity,
            sessionTime: SessionTime?
    ){
        sessionTime?.let {
            activity.idValue = insertNewValue(it)
        }
        insertNewCar(activity)
    }

    @Transaction
    open suspend fun updateCarWithValue(
            activity: Activity,
            sessionTime: SessionTime?
    ){
        sessionTime?.let {
            updateValue(it)
        }
        updateCar(activity)
    }

    @Query(
        "SELECT car.id, car.cantSeats, car.price, car.isNew, " +
        "car.model, car.dateRelease, category.id AS categoryId,category.name AS categoryName, " +
        "category.valueName, value.id AS valueQuantityId,value.quantity AS valueQuantity, " +
        "value.unit AS valueQuantityUnit FROM car LEFT JOIN category ON car.idCategory =" +
        " category.id LEFT JOIN value ON car.idValue = value.id"
    )
    fun getAllCars(): LiveData<List<CarModel>>

    @Query("SELECT * FROM category")
    fun getAllCategories(): LiveData<List<DailyTime>>

}