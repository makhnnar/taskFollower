package com.pedrogomez.taskfollower.domian.view

data class FormState(
    val nameError: Int? = null,
    val timeError: Int? = null,
    val isDataValid: Boolean = false
)
