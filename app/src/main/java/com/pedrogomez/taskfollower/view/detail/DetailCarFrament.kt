package com.pedrogomez.taskfollower.view.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.pedrogomez.taskfollower.R
import com.pedrogomez.taskfollower.base.FragmentBase
import com.pedrogomez.taskfollower.databinding.FragmentDetailBinding
import com.pedrogomez.taskfollower.domian.view.TaskVM
import com.pedrogomez.taskfollower.presentation.TaskViewModel
import org.koin.android.viewmodel.ext.android.getViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class DetailCarFrament : FragmentBase(),
    DetailCarView.UserActions{

    private val carsViewModel : TaskViewModel by viewModel()

    private lateinit var binding: FragmentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentDetailBinding.inflate(
            inflater,
            container,
            false
        )
        val view = binding.root
        binding.detailView.userActions = this
        initObservers()
        return view
    }

    private fun initObservers(){
        /*carsViewModel.getCarToView().observe(
                viewLifecycleOwner,
                Observer {
                    binding.detailView.setData(it)
                }
        )*/
    }

    override fun editItem(taskVM: TaskVM) {
        //carsViewModel.setCarToEdit(taskVM)
        //findNavController().navigate(R.id.action_detailFragment_to_editCreateFragment)
    }

}