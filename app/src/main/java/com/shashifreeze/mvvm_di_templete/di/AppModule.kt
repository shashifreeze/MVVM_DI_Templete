package com.shashifreeze.mvvm_di_templete.di

import com.shashifreeze.mvvm_di_templete.view.ui.main.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
@Author: Shashi
@Date: 19-03-2021
@Description: Provides Objects in the application scope
*/
@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    /**
     * @param: NA
     * @return: CategoriesRepository
     * @author: Shashi
     * Creates and provides CategoriesRepository object reference
     */
    @Provides
    @Singleton
    fun provideCategoriesRepository(): MainRepository = MainRepository()

}