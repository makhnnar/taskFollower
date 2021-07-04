package com.pedrogomez.taskfollower.base

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

open class FragmentBase : Fragment(){

    fun hideKeyboard(view: View?) {
        if (view != null) {
            val imm = activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
            try {
                //imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_IMPLICIT_ONLY);
            } catch (e: Exception) {
            }
        }
    }

}