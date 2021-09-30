//package com.vendeor.base
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.vendeor.network.api.AuthAPI
//import com.shashifreeze.mvvm_di_templete.network.RemoteDataSource
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.withContext
//import javax.inject.Inject
//
//
///**
//@Author: Shashi
//@Date: 22-03-2021
//@Description:
//*/
//
//class BaseViewModel : ViewModel() {
//
//    private val _loading = MutableLiveData<Boolean>()
//    val loading: LiveData<Boolean>
//        get() = _loading
//
//    fun notifyLoading(isLoading: Boolean) {
//        _loading.value = isLoading
//    }
//
//    //suspend fun logout(api:AuthAPI) = withContext(Dispatchers.IO){ baseRepository.logout(api) }
//
//}