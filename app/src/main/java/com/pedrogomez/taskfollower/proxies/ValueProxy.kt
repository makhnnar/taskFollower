package com.pedrogomez.taskfollower.proxies

import com.pedrogomez.taskfollower.domian.view.TaskVM

//not implemented. was dessingned for carmodel fields validation
class ValueProxy : ValueContract {

    override fun checkFields(
            carFromView: TaskVM,
            valueActions: ValueActions
    ) {
        /*if(carFromView.valueName?.isEmpty() == true){
            valueActions.onDeniedValidation("")
            return
        }
        if(carFromView.categoryName?.isEmpty() == true){
            valueActions.onDeniedValidation("")
            return
        }
        if(carFromView.dateRelease?.isEmpty() == true){
            valueActions.onDeniedValidation("")
            return
        }
        if(carFromView.model?.isEmpty() == true){
            valueActions.onDeniedValidation("")
            return
        }*/
        valueActions.onAcceptValidation(carFromView)
    }

}