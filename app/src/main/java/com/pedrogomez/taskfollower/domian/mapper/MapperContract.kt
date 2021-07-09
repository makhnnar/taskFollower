package com.pedrogomez.taskfollower.domian.mapper

import com.pedrogomez.taskfollower.domian.db.TaskDBM
import com.pedrogomez.taskfollower.domian.db.SessionTimeDBM
import com.pedrogomez.taskfollower.domian.view.TaskVM

interface MapperContract<VM,DB> {

    fun fromVMtoDB(vm: VM) : DB

    fun fromDBtoVM(db: DB) : VM

}