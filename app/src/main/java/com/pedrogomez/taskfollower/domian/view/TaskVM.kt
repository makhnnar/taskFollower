package com.pedrogomez.taskfollower.domian.view

import androidx.room.ColumnInfo
import java.text.FieldPosition

data class TaskVM (
        val id:Long,
        var name:String,
        var price:Int,
        var isProgress:Boolean,
        var isRunning:Boolean,
        var lastTimeRunning:Long,
        var position: Int
)