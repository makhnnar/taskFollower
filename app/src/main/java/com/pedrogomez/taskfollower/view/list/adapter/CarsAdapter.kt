package com.pedrogomez.taskfollower.view.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.pedrogomez.taskfollower.domian.view.TaskVM
import com.pedrogomez.taskfollower.view.list.ListCarsView

class CarsAdapter(
        private var listener:ListCarsView.ItemListActions?
) : ListAdapter<TaskVM, CarsVH>(CarsDC()) {

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): CarsVH {
        val inflater = LayoutInflater.from(
            parent.context
        )
        return CarsVH(
            inflater,
            parent
        )
    }

    override fun onBindViewHolder(
            holder: CarsVH,
            position: Int
    ) {
        val item = getItem(position)
        holder.setData(
            item,
            listener
        )
    }

}