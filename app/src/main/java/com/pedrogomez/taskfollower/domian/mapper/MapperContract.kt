package com.pedrogomez.taskfollower.domian.mapper

import com.pedrogomez.taskfollower.domian.db.Activity
import com.pedrogomez.taskfollower.domian.db.SessionTime
import com.pedrogomez.taskfollower.domian.view.CarModel

interface MapperContract {

    fun getCarAsModelForDB(carModel: CarModel) : Activity

    fun getValueAsModelForDB(carModel: CarModel) : SessionTime?

}