package com.pedrogomez.taskfollower.proxies

import com.pedrogomez.taskfollower.domian.view.TaskVM

interface ValueActions {

    fun onAcceptValidation(carFromView: TaskVM)

    fun onDeniedValidation(msg:String)

}