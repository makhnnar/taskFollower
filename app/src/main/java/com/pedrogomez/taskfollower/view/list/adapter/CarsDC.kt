package com.pedrogomez.taskfollower.view.list.adapter

import androidx.recyclerview.widget.DiffUtil
import com.pedrogomez.taskfollower.domian.view.TaskVM

class CarsDC : DiffUtil.ItemCallback<TaskVM>() {

    override fun areItemsTheSame(oldItem: TaskVM, newItem: TaskVM): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TaskVM, newItem: TaskVM): Boolean {
        return oldItem == newItem
    }

}