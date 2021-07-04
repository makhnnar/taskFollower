package com.pedrogomez.taskfollower.domian.mapper

import com.pedrogomez.taskfollower.domian.db.Activity
import com.pedrogomez.taskfollower.domian.db.SessionTime
import com.pedrogomez.taskfollower.domian.view.CarModel

class ViewToDBMapper : MapperContract {

    override fun getCarAsModelForDB(carModel: CarModel): Activity {
        return Activity(
                carModel.id?:0,
                carModel.cantSeats?:"0",
                carModel.price?:"0",
                carModel.isNew?:true,
                carModel.model?:"",
                carModel.dateRelease?:"",
                carModel.categoryId?:1,
                carModel.valueQuantityId,
        )
    }

    override fun getValueAsModelForDB(carModel: CarModel): SessionTime? {
        if(carModel.valueQuantity!=null && carModel.valueQuantityUnit!=null){
            return SessionTime(
                    carModel.valueQuantityId?:0,
                    carModel.valueQuantity?:"",
                    carModel.valueQuantityUnit?:"",
            )
        }
        return null
    }

}