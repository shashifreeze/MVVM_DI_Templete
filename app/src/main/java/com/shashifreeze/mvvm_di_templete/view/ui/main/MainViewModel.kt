package com.shashifreeze.mvvm_di_templete.view.ui.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @constructor: private val repository: MainRepository
 * @author: Shashi
 * View model for Main Activity*/
@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {


}