package com.pedrogomez.taskfollower.domian.mapper

import com.pedrogomez.taskfollower.domian.db.SessionTimeDBM
import com.pedrogomez.taskfollower.domian.db.TaskDBM
import com.pedrogomez.taskfollower.domian.view.SessionTimeVM
import com.pedrogomez.taskfollower.domian.view.TaskVM

class SessionTimeMapper : MapperContract<SessionTimeVM, SessionTimeDBM> {
    override fun fromVMtoDB(vm: SessionTimeVM): SessionTimeDBM {
        TODO("Not yet implemented")
    }

    override fun fromDBtoVM(db: SessionTimeDBM): SessionTimeVM {
        TODO("Not yet implemented")
    }
}