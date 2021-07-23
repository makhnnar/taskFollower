package com.pedrogomez.taskfollower.domian.view

import androidx.room.ColumnInfo
import java.text.FieldPosition

data class TaskVM (
        val id:Long = 0,
        var name:String? = "",
        var assignedTime:Int? = 0,
        var isProgress:Boolean = false,
        var isRunning:Boolean = false,
        var lastTimeRunning:Long = 0,
        var position: Int = 0
)