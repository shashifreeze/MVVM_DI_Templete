package com.shashifreeze.mvvm_di_templete.preference

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Singleton

//top level
//@todo replace preference name
private const val PREFERENCE_NAME = "Your app pref name here"
val Context.userDatastore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCE_NAME)

/**
 *Singleton class
 *
 */
@Singleton
object UserPreferences {

    //Constants
    private val KEY_USERNAME = stringPreferencesKey("KEY_USERNAME")


    /**set username  of the user in datastore*/
    suspend fun saveUsername(context: Context, userName: String) {
        context.userDatastore.apply {
            edit { it[KEY_USERNAME] = userName }
        }
    }

    /**Get username*/
    fun getUsername(context: Context): Flow<String> =
        context.userDatastore.data.map {
            if ((it[KEY_USERNAME]) != null) it[KEY_USERNAME]!! else "Username"
        }

    /**CLEAR current logged in user details from datastore*/
    suspend fun clear(context: Context) =
        context.userDatastore.edit {
            it.clear()
        }
}