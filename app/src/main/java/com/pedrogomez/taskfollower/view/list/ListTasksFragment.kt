package com.pedrogomez.taskfollower.view.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.pedrogomez.taskfollower.R
import com.pedrogomez.taskfollower.base.FragmentBase
import com.pedrogomez.taskfollower.databinding.FragmentEditCreateBinding
import com.pedrogomez.taskfollower.databinding.FragmentListBinding
import com.pedrogomez.taskfollower.domian.view.TaskVM
import com.pedrogomez.taskfollower.presentation.TaskViewModel
import org.koin.android.viewmodel.ext.android.getViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class ListTasksFragment : FragmentBase(),
    ListCarsView.UserActions,
    ListCarsView.ItemListActions{

    private val carsViewModel : TaskViewModel by viewModel()

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
        carsViewModel.task().observe(
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
        findNavController().navigate(
            R.id.action_listFragment_to_editCreateTaskDialog
        )
    }

    override fun goToDetail(taskVM: TaskVM) {
        findNavController().navigate(
            R.id.action_listFragment_to_editCreateTaskDialog
        )
    }

}