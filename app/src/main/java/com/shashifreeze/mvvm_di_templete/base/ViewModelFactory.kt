package com.shashifreeze.mvvm_di_templete.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shashifreeze.mvvm_di_templete.view.ui.main.MainRepository
import com.shashifreeze.mvvm_di_templete.view.ui.main.MainViewModel

/**
 * @author: Shashi
 * Model view factory to create view models */
@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repo1: BaseRepository, private val repo2: BaseRepository?=null) :
    ViewModelProvider.NewInstanceFactory() {
    /**
     * @author: Shashi
     * Creates objects of a view model specified*/
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(repo1 as MainRepository) as T
            }
            else -> throw IllegalArgumentException("View model not found")
        }
    }
}