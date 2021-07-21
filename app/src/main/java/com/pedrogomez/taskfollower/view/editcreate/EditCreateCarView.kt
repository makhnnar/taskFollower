package com.pedrogomez.taskfollower.view.editcreate

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatSpinner
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.pedrogomez.taskfollower.R
import com.pedrogomez.taskfollower.databinding.ViewEditCreateBinding
import com.pedrogomez.taskfollower.domian.db.DailyTimeDBM
import com.pedrogomez.taskfollower.domian.view.TaskVM
import kotlin.collections.ArrayList

class EditCreateCarView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle){

    var binding : ViewEditCreateBinding = ViewEditCreateBinding.inflate(
            LayoutInflater.from(context),
            this
    )

    private var etModel : TextInputEditText

    private var etPrice : TextInputEditText

    private var sCategory : TextInputLayout

    private var sPinner : AutoCompleteTextView

    private var btnSave : ImageView

    private var btnCancel : ImageView

    private var taskVM: TaskVM? = null

    private var categories = ArrayList<DailyTimeDBM>()

    var userActions : UserActions? = null

    init{
        attrs.let {

        }
        etModel = binding.etModel
        etPrice = binding.etPrice
        sCategory = binding.sCategory
        sPinner = binding.mySpinnerDropdown
        btnSave =  binding.btnAdd
        btnCancel =  binding.btnDiscard
        btnSave.setOnClickListener {

        }
        btnCancel.setOnClickListener {

        }
        sPinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?, position: Int,
                    id: Long
            ) {
                if(position<categories.size){
                    //lbCatValue.text = "${categories[position].value}"
                }else{
                    sCategory.visibility = View.GONE
                }
            }

            override fun onNothingSelected(
                    parent: AdapterView<*>?
            ) {

            }

        }
        val array : Array<String> = resources.getStringArray(R.array.state_car)
        val dataAdapter: ArrayAdapter<*> = ArrayAdapter<Any?>(
                this.context,
                R.layout.simple_spinner_item,
                array.toList()
        )
        //sPinner.adapter = dataAdapter
    }

    interface UserActions{

        fun saveItem(taskVM: TaskVM)

        fun saveCategory(dailyTimeDBM: DailyTimeDBM)

    }
}