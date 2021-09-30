package com.shashifreeze.mvvm_di_templete.base

import android.util.Log
import com.vendeor.network.Resource
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import retrofit2.HttpException

/***
 * @author: Shashi
 * Base repository for all the repository   */
abstract class BaseRepository {

    /**
     * @param: apiCall: suspend () -> T
     * @return: Resource<T>
     * @author: Shashi
     * Makes safe API call and wraps the response in Resource<T> */
    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): Resource<T> {
        return withContext(IO) {
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