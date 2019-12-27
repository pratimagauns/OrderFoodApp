package com.pratima.foodorderapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pratima.foodorderapp.repositories.UserRepository
import javax.inject.Inject

class LoginViewModel  @Inject constructor(private val repository: UserRepository) : ViewModel() {

    var projectsLiveData = MutableLiveData<Boolean>()

    fun logUserIn() {
        projectsLiveData.postValue(true)
    }

}