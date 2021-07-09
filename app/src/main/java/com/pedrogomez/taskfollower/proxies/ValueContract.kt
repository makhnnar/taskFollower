package com.pedrogomez.taskfollower.proxies

import com.pedrogomez.taskfollower.domian.view.TaskVM

interface ValueContract {

    fun checkFields(
            carFromView: TaskVM,
            valueActions: ValueActions
    )

}