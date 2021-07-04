package com.pedrogomez.taskfollower.view.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.pedrogomez.taskfollower.R
import com.pedrogomez.taskfollower.base.FragmentBase
import com.pedrogomez.taskfollower.databinding.FragmentListBinding
import com.pedrogomez.taskfollower.domian.view.CarModel
import com.pedrogomez.taskfollower.presentation.CarsViewModel
import org.koin.android.viewmodel.ext.android.getViewModel

class ListCarsFragment : FragmentBase(),
    ListCarsView.UserActions,
    ListCarsView.ItemListActions{

    private val carsViewModel by lazy {
        requireParentFragment().getViewModel<CarsViewModel>()
    }

    private lateinit var binding: FragmentListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentListBinding.inflate(
            inflater,
            container,
            false
        )
        val view = binding.root
        binding.listView.userActions = this
        binding.listView.itemListActions = this
        binding.listView.hideBtnTop()
        initObservers()
        return view
    }

    private fun initObservers(){
        carsViewModel.carsList.observe(
            viewLifecycleOwner,
            Observer {
                if(it.isNotEmpty()){
                    binding.noElements.visibility = View.GONE
                    binding.listView.setData(it)
                }
            }
        )
    }

    override fun addNewItem() {
        carsViewModel.setCarToEdit(null)
        findNavController().navigate(R.id.action_listFragment_to_editCreateFragment)
    }

    override fun goToDetail(carModel: CarModel) {
        carsViewModel.setCarToView(carModel)
        findNavController().navigate(R.id.action_listFragment_to_detailFragment)
    }

}