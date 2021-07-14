package com.pedrogomez.taskfollower.domian.mapper

import com.pedrogomez.taskfollower.domian.db.TaskDBM
import com.pedrogomez.taskfollower.domian.db.SessionTimeDBM
import com.pedrogomez.taskfollower.domian.view.TaskVM

class TaskModelMapper : MapperContract<TaskVM,TaskDBM> {

    override fun fromVMtoDB(vm: TaskVM): TaskDBM {
        val (
            id,
            name,
            price,
            isProgress,
            isRunning,
            lastTimeRunning,
            position
        ) = vm
        return TaskDBM(
                id,
                name,
                price,
                isProgress,
                isRunning,
                lastTimeRunning,
                position
        )
    }

    override fun fromDBtoVM(db: TaskDBM): TaskVM {
        val (
                id,
                name,
                price,
                isProgress,
                isRunning,
                lastTimeRunning,
                position
        ) = db
        return TaskVM(
                id,
                name,
                price,
                isProgress,
                isRunning,
                lastTimeRunning,
                position
        )
    }


}