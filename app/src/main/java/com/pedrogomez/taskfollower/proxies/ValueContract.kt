package com.pedrogomez.taskfollower.proxies

import com.pedrogomez.taskfollower.domian.view.CarModel

interface ValueContract {

    fun checkFields(
            carFromView: CarModel,
            valueActions: ValueActions
    )

}