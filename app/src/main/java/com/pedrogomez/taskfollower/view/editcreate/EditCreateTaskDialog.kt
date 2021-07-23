package com.pedrogomez.taskfollower.view.editcreate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.pedrogomez.taskfollower.R
import com.pedrogomez.taskfollower.databinding.FragmentEditCreateBinding
import com.pedrogomez.taskfollower.presentation.TaskViewModel
import com.pedrogomez.taskfollower.view.editcreate.view.EditCreateView
import org.koin.android.viewmodel.ext.android.getViewModel

class EditCreateTaskDialog : BottomSheetDialogFragment(),
    EditCreateView.UserActions{

    private val taskViewModel by lazy {
        requireParentFragment().getViewModel<TaskViewModel>()
    }

    private var editView : EditCreateView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(
            DialogFragment.STYLE_NORMAL,
            R.style.SelectSectionDialogTheme
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentEditCreateBinding.inflate(
            inflater,
            container,
            false
        )
        editView = binding.editCreateView
        editView?.userActions = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        taskViewModel.taskFormState.observe(
            this@EditCreateTaskDialog,
            Observer {
                if(!it.isDataValid){
                    editView?.setErrors(
                        it.nameError,
                        it.timeError
                    )
                }else{
                    this@EditCreateTaskDialog.dismiss()
                }
            }
        )
    }

    override fun saveItem(
        name:String?,
        assignedTime:String?,
        isProgress:Boolean
    ) {
        taskViewModel.taskDataChanged(
            name,
            assignedTime,
            isProgress
        )
    }

    override fun deleteItem() {
        this.dismiss()
    }

    override fun cancelEditOrCretion() {
        this.dismiss()
    }

}