package com.pratima.foodorderapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pratima.foodorderapp.repositories.UserRepository
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val repository: UserRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(repository) as T
        }
        if(modelClass.isAssignableFrom(OTPViewModel::class.java)) {
            return OTPViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown class")
    }
}