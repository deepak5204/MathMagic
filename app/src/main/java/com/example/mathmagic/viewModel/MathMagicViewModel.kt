package com.example.mathmagic.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MathMagicViewModel @Inject constructor() : ViewModel(){

    var digitSize = ""
}