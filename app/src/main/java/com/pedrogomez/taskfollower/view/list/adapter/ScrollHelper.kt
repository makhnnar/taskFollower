package com.pedrogomez.taskfollower.view.list.adapter

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ScrollHelper (
        private val linearLayoutManager: LinearLayoutManager?,
        private val onScrollEvents:OnScrollEvents?,
) : RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
    }

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
        val visiblePos = linearLayoutManager?.findFirstCompletelyVisibleItemPosition()?:0
        if(visiblePos<1){
            onScrollEvents?.isOnTop()
        }else{
            onScrollEvents?.isNotOnTop()
        }
    }

    interface OnScrollEvents{

        fun isOnTop()

        fun isNotOnTop()

    }

}