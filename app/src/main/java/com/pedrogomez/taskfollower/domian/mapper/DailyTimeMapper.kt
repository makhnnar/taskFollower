package com.pedrogomez.taskfollower.domian.mapper

import com.pedrogomez.taskfollower.domian.db.DailyTimeDBM
import com.pedrogomez.taskfollower.domian.view.DailyTimeVM

class DailyTimeMapper : MapperContract<DailyTimeVM,DailyTimeDBM> {
    override fun fromVMtoDB(vm: DailyTimeVM): DailyTimeDBM {
        TODO("Not yet implemented")
    }

    override fun fromDBtoVM(db: DailyTimeDBM): DailyTimeVM? {
        TODO("Not yet implemented")
    }
}