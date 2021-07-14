package com.pedrogomez.taskfollower.view.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.pedrogomez.taskfollower.domian.view.TaskVM
import com.pedrogomez.taskfollower.view.list.ListCarsView

class TasksAdapter(
        private var listener:ListCarsView.ItemListActions?
) : ListAdapter<TaskVM, TasksVH>(TasksDC()) {

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): TasksVH {
        val inflater = LayoutInflater.from(
            parent.context
        )
        return TasksVH(
            inflater,
            parent
        )
    }

    override fun onBindViewHolder(
        holder: TasksVH,
        position: Int
    ) {
        val item = getItem(position)
        holder.setData(
            item,
            listener
        )
    }

}