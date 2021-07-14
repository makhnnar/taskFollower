package com.pedrogomez.taskfollower.view.detail

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.pedrogomez.taskfollower.databinding.ViewDetailBinding
import com.pedrogomez.taskfollower.domian.view.TaskVM

class DetailCarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle){

    var binding : ViewDetailBinding = ViewDetailBinding.inflate(
        LayoutInflater.from(context), this
    )

    private var tvModel : AppCompatTextView? = null

    private var tvPrice : AppCompatTextView? = null

    private var tvState : AppCompatTextView? = null

    private var tvSeats : AppCompatTextView? = null

    private var tvDate : AppCompatTextView? = null

    private var tvCategory : AppCompatTextView? = null

    private var tvCatValue : AppCompatTextView? = null

    private var lbCatValue : AppCompatTextView? = null

    var btnEdit : FloatingActionButton? = null

    private var taskVM: TaskVM? = null

    var userActions : UserActions? = null

    init{
        attrs.let {

        }
        tvModel = binding.tvModel
        tvPrice = binding.tvPrice
        tvState = binding.tvState
        tvSeats = binding.tvSeats
        tvDate = binding.tvRelease
        tvCategory = binding.tvCategory
        tvCatValue = binding.tvCategoryValue
        lbCatValue = binding.lbCategoryValue
        btnEdit = binding.btnEdit
        btnEdit?.setOnClickListener {
            taskVM?.let { carModel ->
                userActions?.editItem(carModel)
            }
        }
    }

    fun setData(taskVM: TaskVM){
        this.taskVM = taskVM
        /*tvModel?.text = taskVM.model
        tvPrice?.text = taskVM.assignedTime
        tvState?.text = getState(taskVM.isNew?:false)
        tvSeats?.text = taskVM.cantSeats
        tvDate?.text = taskVM.dateRelease
        tvCategory?.text = taskVM.categoryName
        if(taskVM.valueName!=null){
            lbCatValue?.text = taskVM.valueName
            tvCatValue?.text = taskVM.valueQuantity
        }else{
            lbCatValue?.visibility = View.GONE
            tvCatValue?.visibility = View.GONE
        }*/

    }

    private fun getState(isNew:Boolean):String{
        return if(isNew) "New" else "Used"
    }

    interface UserActions{

        fun editItem(taskVM: TaskVM)

    }

}