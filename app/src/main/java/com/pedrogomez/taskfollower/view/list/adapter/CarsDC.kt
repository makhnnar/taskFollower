package com.pedrogomez.taskfollower.view.list.adapter

import androidx.recyclerview.widget.DiffUtil
import com.pedrogomez.taskfollower.domian.view.CarModel

class CarsDC : DiffUtil.ItemCallback<CarModel>() {

    override fun areItemsTheSame(oldItem: CarModel, newItem: CarModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CarModel, newItem: CarModel): Boolean {
        return oldItem == newItem
    }

}