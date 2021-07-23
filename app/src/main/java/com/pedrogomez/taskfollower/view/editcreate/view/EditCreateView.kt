package com.pedrogomez.taskfollower.view.editcreate.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.AdapterView
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.checkbox.MaterialCheckBox
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.pedrogomez.taskfollower.R
import com.pedrogomez.taskfollower.databinding.ViewEditCreateBinding
import com.pedrogomez.taskfollower.domian.db.DailyTimeDBM
import com.pedrogomez.taskfollower.domian.view.TaskVM
import com.pedrogomez.taskfollower.view.editcreate.SpinnerListAdapter
import kotlin.collections.ArrayList

class EditCreateView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle){

    val TAG = EditCreateView::class.simpleName

    var binding : ViewEditCreateBinding = ViewEditCreateBinding.inflate(
            LayoutInflater.from(context),
            this
    )

    private var etNameTask : TextInputEditText

    private var etAssingTime : TextInputEditText

    private var sCategory : TextInputLayout

    private var checkBox : MaterialCheckBox

    private var sPinner : AutoCompleteTextView

    private var btnSave : ImageView

    private var btnCancel : ImageView

    private var btnDelete : ImageView

    private var taskVM: TaskVM? = null

    private var categories = ArrayList<DailyTimeDBM>()

    var userActions : UserActions? = null

    val array : Array<String> = resources.getStringArray(
        R.array.state_car
    )

    init{
        attrs.let {

        }
        etNameTask = binding.etNameTask
        etAssingTime = binding.etAssinedTime
        sCategory = binding.sCategory
        sPinner = binding.mySpinnerDropdown
        btnSave =  binding.btnAdd
        btnCancel =  binding.btnDiscard
        btnDelete =  binding.btnDelete
        checkBox =  binding.checkCounter
        btnSave.setOnClickListener {
            userActions?.saveItem(
                etNameTask.text.toString(),
                etAssingTime.text.toString(),
                checkBox.isChecked
            )
        }
        btnCancel.setOnClickListener {
            userActions?.cancelEditOrCretion()
        }
        btnDelete.setOnClickListener {
            userActions?.deleteItem()
        }
        sPinner.onItemClickListener = AdapterView.OnItemClickListener { parent, arg1, position, id ->
            Log.i(TAG, "onItemSelected: ${array[position]}")
            sPinner.setText(
                array[position]
            )
        }

        context?.let {
            sPinner.setAdapter(
                SpinnerListAdapter(
                    it,
                    R.layout.simple_spinner_item,
                    array
                )
            )
        }
    }

    fun setItem(
        name:String,
        assignedTime:String,
        isProgress:Boolean
    ){
        etNameTask.setText(name)
        etAssingTime.setText(name)
        checkBox.isChecked = isProgress
    }

    fun setErrors(
        nameError: Int?,
        timeError: Int?
    ) {
        nameError?.let {
            etNameTask.error = context.getString(it)
        }
        timeError?.let {
            etAssingTime.error = context.getString(it)
        }
    }

    interface UserActions{

        fun saveItem(
            name:String?,
            assignedTime:String?,
            isProgress:Boolean
        )

        fun deleteItem()

        fun cancelEditOrCretion()

    }
}