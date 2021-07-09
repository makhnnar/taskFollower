package com.pedrogomez.taskfollower.view.list.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.pedrogomez.taskfollower.R
import com.pedrogomez.taskfollower.databinding.ViewHolderItemBinding
import com.pedrogomez.taskfollower.domian.view.TaskVM
import com.pedrogomez.taskfollower.view.list.ListCarsView

class CarsVH(
    inflater: LayoutInflater,
    parent: ViewGroup
) : RecyclerView.ViewHolder(
    inflater.inflate(
        R.layout.view_holder_item,
        parent,
        false
    )
) {

    private var context : Context

    private var binding: ViewHolderItemBinding? = null

    private var data: TaskVM? = null

    private var model : AppCompatTextView? = null

    private var price : AppCompatTextView? = null

    private var category : AppCompatTextView? = null

    private var clBgCard : ConstraintLayout? = null

    init {
        binding = ViewHolderItemBinding.bind(itemView)
        context = parent.context
        model = binding?.tvModel
        price = binding?.tvPrice
        category = binding?.tvCategory
        clBgCard = binding?.clBgCard
    }

    fun setData(
            item: TaskVM?,
            itemListActions: ListCarsView.ItemListActions?
    ) {
        item?.let {
            model?.text = it.model
            price?.text = it.price
            category?.text = it.categoryName
        }
        clBgCard?.setOnClickListener {
            item?.let{
                itemListActions?.goToDetail(it)
            }
        }
    }

}