package com.example.myspace

import android.content.Context
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val utility: Utility,
    context: Context
) : ViewModel() {

}