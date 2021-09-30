//package com.vendeor.base
//
//import android.content.Context
//import android.util.AttributeSet
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.appcompat.app.AppCompatActivity
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import androidx.lifecycle.lifecycleScope
//import androidx.viewbinding.ViewBinding
//import com.shashifreeze.mvvm_di_templete.network.RemoteDataSource
//import com.vendeor.preferences.UserPreferences
//import kotlinx.coroutines.flow.first
//import kotlinx.coroutines.launch
//
///*
//@Author: Shashi
//@Date: 17-03-2021
//@Description:
//*/
//
//abstract class BaseActivity<VM: ViewModel,B: ViewBinding, R: BaseRepository>: AppCompatActivity() {
//
//    //view binding variable
//    protected lateinit var binding: B
//    protected val remoteDataSource = RemoteDataSource()
//    protected lateinit var viewModel: VM
//    protected lateinit var userPrefences: UserPreferences
//
//    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
//
//        userPrefences = UserPreferences(context)
//        binding = getActivityBinding(layoutInflater)
//        val factory = ViewModelFactory(getActivityRepository())
//        viewModel = ViewModelProvider(this, factory).get(getViewModel())
//        //making it available for future calls of dataStore
//        lifecycleScope.launch {
//            userPrefences.getUserData().first()
//        }
//        return binding.root
//    }
//
//    //get actual view model
//    abstract fun getViewModel(): Class<VM>
//
//    //get fragment binding actual class
//    abstract fun getActivityBinding(inflater: LayoutInflater): B
//
//    //get actual fragment repository
//    abstract fun getActivityRepository(): R
//}