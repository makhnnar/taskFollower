package com.pedrogomez.taskfollower.view.list

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ProgressBar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.pedrogomez.taskfollower.databinding.ViewListBinding
import com.pedrogomez.taskfollower.domian.view.CarModel
import com.pedrogomez.taskfollower.view.list.adapter.CarsAdapter
import com.pedrogomez.taskfollower.view.list.adapter.ScrollHelper

class ListCarsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle),
    ScrollHelper.OnScrollEvents{

    var binding : ViewListBinding = ViewListBinding.inflate(
            LayoutInflater.from(context),
            this
    )

    var btnUp : FloatingActionButton

    var btnAdd : FloatingActionButton

    var rvItems : RecyclerView

    var loader : ProgressBar

    var itemListActions : ItemListActions? = null

    var userActions : UserActions? = null

    private lateinit var scrollHelper: ScrollHelper

    private lateinit var cAdapter : CarsAdapter

    private lateinit var lManager : LinearLayoutManager

    init{
        attrs.let {

        }
        btnUp = binding.btnToTop
        btnAdd = binding.btnAdd
        rvItems = binding.rvItems
        loader = binding.pbLoader
        btnUp?.setOnClickListener {
            rvItems?.smoothScrollToPosition(0)
        }
        btnAdd?.setOnClickListener {
            userActions?.addNewItem()
        }
    }

    fun setData(items: List<CarModel>){
        initRecyclerView()
        cAdapter.submitList(items)
    }

    private fun initRecyclerView() {
        cAdapter = CarsAdapter(
                itemListActions
        )
        lManager = LinearLayoutManager(context)
        rvItems?.apply{
            adapter = cAdapter
            layoutManager = lManager
        }
        scrollHelper = ScrollHelper(
                lManager,
                this
        )
        rvItems?.addOnScrollListener(
                scrollHelper
        )
    }

    interface UserActions{

        fun addNewItem()

    }

    interface ItemListActions{

        fun goToDetail(carModel:CarModel)

    }

    fun hideBtnTop(){
        btnUp?.hide()
    }

    override fun isOnTop() {
        hideBtnTop()
    }

    override fun isNotOnTop() {
        btnUp?.show()
    }

}