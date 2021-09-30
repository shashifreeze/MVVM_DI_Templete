package com.vendeor.base

import android.util.Log
import com.vendeor.network.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

/**
 *@author = Shashi
 *@date = 13/09/21
 *@description = This class handles
 */
abstract class BaseDataSource {

    /**
     * @param: apiCall: suspend () -> T
     * @return: Resource<T>
     * @author: Shashi
     * Makes safe API call and wraps the response in Resource<T> */
    suspend fun <T> getResult(
        apiCall: suspend () -> T
    ): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                Resource.Success(apiCall.invoke())

            } catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException -> {
                        Log.d("BaseRepository","BaseRepository:${throwable.response()}\n${throwable.code()}")
                        Resource.Failure(isNetworkError = false, errorCode = throwable.code(), errorBody = throwable.response()?.errorBody(),message = throwable.message)
                    }
                    else -> {
                        Resource.Failure(isNetworkError = true, errorCode = null, errorBody = null,message = throwable.message)
                    }
                }
            }
        }
    }
}