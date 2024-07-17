package com.application.composeapplication

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SharedViewModel:ViewModel() {
    private val _editTextState = mutableStateOf("")
     var editTextState = _editTextState

}