package com.pedrogomez.taskfollower.domian.view

data class DailyTimeVM(
        val id:Long,
        val idActivity:Long,
        val date:Long,
        var spendedTime:Long = 0
)
