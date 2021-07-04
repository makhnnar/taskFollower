package com.pedrogomez.taskfollower.proxies

import com.pedrogomez.taskfollower.domian.view.CarModel

interface ValueActions {

    fun onAcceptValidation(carFromView: CarModel)

    fun onDeniedValidation(msg:String)

}