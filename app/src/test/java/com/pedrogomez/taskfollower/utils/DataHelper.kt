package com.pedrogomez.taskfollower.utils

import androidx.lifecycle.liveData
import com.pedrogomez.taskfollower.domian.db.Activity
import com.pedrogomez.taskfollower.domian.db.DailyTime
import com.pedrogomez.taskfollower.domian.db.SessionTime
import com.pedrogomez.taskfollower.domian.view.CarModel

class DataHelper {

    companion object{

        val carView = CarModel(
            1,
            0,
            0.0,
            true,
            "model",
            "dateRelease",
            0,
            "categoryName",
            "valueName",
            0,
            0.0,
            "valueUnit"
        )

        val carDB = Activity(
            1,
            0,
            0.0,
            true,
            "model",
            "dateRelease",
            1,
            1
        )

        val categoryDB = DailyTime(
            1,
            "name",
            "value"
        )

        val valueDB = SessionTime(
            1,
            0.0,
            "unit"
        )

        val listCategories = listOf(
            categoryDB
        )

        val categoriesListLD = liveData<List<DailyTime>> { listCategories }

        val listCars = listOf(
            carView
        )

        val carsListLD = liveData<List<CarModel>> { listCars }

    }

}