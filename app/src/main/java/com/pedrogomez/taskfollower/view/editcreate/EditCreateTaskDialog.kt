package com.pedrogomez.taskfollower.view.editcreate

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.pedrogomez.taskfollower.R
import com.pedrogomez.taskfollower.databinding.FragmentEditCreateBinding
import com.pedrogomez.taskfollower.domian.db.DailyTimeDBM
import com.pedrogomez.taskfollower.domian.view.TaskVM
import com.pedrogomez.taskfollower.presentation.TaskViewModel
import org.koin.android.viewmodel.ext.android.getViewModel

class EditCreateTaskDialog : DialogFragment(),
    EditCreateCarView.UserActions{

    private val carsViewModel by lazy {
        requireParentFragment().getViewModel<TaskViewModel>()
    }

    protected var listener: InvitationListener? = null

    companion object {

        fun newInstance(listener: InvitationListener): EditCreateTaskDialog {
            val dialogFragment = EditCreateTaskDialog()
            dialogFragment.listener = listener
            return dialogFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(
            DialogFragment.STYLE_NORMAL,
            R.style.SelectSectionDialogTheme
        )

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.fragment_edit_create)

        //decline_terms = dialog.findViewById(R.id.btn_close)

        return dialog
    }

    interface InvitationListener{

        fun goToSignupView()
        fun goBack()

    }

    override fun saveItem(taskVM: TaskVM) {

    }

    override fun saveCategory(dailyTimeDBM: DailyTimeDBM) {

    }

}