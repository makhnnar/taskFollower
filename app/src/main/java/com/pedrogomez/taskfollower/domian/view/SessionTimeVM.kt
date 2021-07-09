package com.pedrogomez.taskfollower.domian.view

data class SessionTimeVM(
        val id:Long,
        val idDailyTime:Long,
        val startTime:Long,
        var endTime:Long = 0
)
