package com.pedrogomez.taskfollower.view.editcreate

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatSpinner
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
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

    private var etModel : AppCompatEditText

    private var etPrice : AppCompatEditText

    private var sState : AppCompatSpinner

    private var etSeats : AppCompatEditText

    private var etDate : AppCompatEditText

    private var sCategory : AppCompatSpinner

    private var etCategory : AppCompatEditText

    private var etCatValue : AppCompatEditText

    private var lbCatValue : AppCompatTextView

    private var btnSaveCar : FloatingActionButton

    private var btnSaveCategory : ImageView

    private var btnCancelCategory : ImageView

    private var taskVM: TaskVM? = null

    private var categories = ArrayList<DailyTimeDBM>()

    var userActions : UserActions? = null

    init{
        attrs.let {

        }
        etModel = binding.etModel
        etPrice = binding.etPrice
        sState = binding.sState
        etSeats = binding.etSeats
        etDate = binding.etRelease
        sCategory = binding.sCategory
        etCategory = binding.etCategory
        etCatValue = binding.tvCategoryValue
        lbCatValue = binding.lbCategoryValue
        btnSaveCar = binding.btnDone
        btnSaveCategory = binding.btnAddCat
        btnCancelCategory = binding.btnDiscardCat
        btnSaveCar.setOnClickListener {
            saveItem()
        }
        btnSaveCategory.setOnClickListener {
            saveCategory()
            hideEtCatAndBtns()
            sCategory.visibility = View.VISIBLE
        }
        btnCancelCategory.setOnClickListener {
            hideEtCatAndBtns()
            sCategory.visibility = View.VISIBLE
        }
        sCategory.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?, position: Int,
                    id: Long
            ) {
                if(position<categories.size){
                    lbCatValue.text = "${categories[position].value}"
                }else{
                    sCategory.visibility = View.GONE
                    showAddCategory()
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
        sState.adapter = dataAdapter
    }

    private fun showAddCategory() {
        btnSaveCategory.visibility = View.VISIBLE
        btnCancelCategory.visibility = View.VISIBLE
        etCategory.visibility = View.VISIBLE
    }

    private fun saveCategory() {
        var category = DailyTimeDBM(
                0,
                etCategory.text.toString(),
                ""
        )
        userActions?.saveCategory(category)
    }

    private fun hideEtCatAndBtns() {
        btnSaveCategory.visibility = View.GONE
        btnCancelCategory.visibility = View.GONE
        etCategory.visibility = View.GONE
    }

    private fun saveItem() {
        val category = categories[sCategory?.selectedItemPosition ?: 0]
        taskVM = TaskVM(
                taskVM?.id?:0,
                etSeats.text.toString(),
                etPrice.text.toString(),
                sState.selectedItemPosition == 0,
                etModel.text.toString(),
                etDate.text.toString(),
                category.id,
                category.name,
                category.value,
                taskVM?.valueQuantityId?:0,
                etCatValue.text.toString(),
                ""
        )
        taskVM?.let {
            userActions?.saveItem(it)
        }
    }

    fun setCategories(dailyTimeDBMS: List<DailyTimeDBM>){
        this.categories.clear()
        this.categories.addAll(dailyTimeDBMS)
        val listTitle : MutableList<String> = dailyTimeDBMS.map {
            it.name
        }.toMutableList()
        listTitle.add("Add Category")
        val dataAdapter: ArrayAdapter<*> = ArrayAdapter<Any?>(
                this.context,
                R.layout.simple_spinner_item,
                listTitle.toList()
        )
        sCategory.adapter = dataAdapter
        taskVM?.let {
            setPositionCategory(it, dailyTimeDBMS)
        }
    }

    private fun setPositionCategory(
            taskVM1: TaskVM,
            dailyTimeDBMS: List<DailyTimeDBM>
    ) {
        if(dailyTimeDBMS.isNotEmpty()){
            lbCatValue.text = taskVM1.valueName?:""
            etCatValue.setText(taskVM1.valueQuantity)
            val selected = dailyTimeDBMS.filter { cat ->
                taskVM1.categoryId == cat.id
            }
            var indexInArray = dailyTimeDBMS.indexOf(selected[0])
            sCategory.setSelection(indexInArray)
        }
    }

    fun setCar(taskVM: TaskVM?){
        hideEtCatAndBtns()
        taskVM?.let {
            this.taskVM = it
            etModel.setText(it.model)
            etPrice.setText(it.price)
            sState.setSelection(
                    getState(it.isNew ?: false)
            )
            etSeats.setText(it.cantSeats)
            etDate.setText(it.dateRelease)
            setPositionCategory(it, categories)
        }
    }

    private fun getState(isNew: Boolean):Int{
        return if(isNew) 0 else 1
    }

    interface UserActions{

        fun saveItem(taskVM: TaskVM)

        fun saveCategory(dailyTimeDBM: DailyTimeDBM)

    }
}