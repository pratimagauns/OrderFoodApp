package com.example.foodorderapp.ui.viewmodel

import android.content.Intent
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodorderapp.repositories.UserRepository
import com.example.foodorderapp.ui.activities.OTPVerificationActivity
import javax.inject.Inject

class LoginViewModel  @Inject constructor(private val repository: UserRepository) : ViewModel() {

    var projectsLiveData = MutableLiveData<Boolean>()

    fun logUserIn() {
        projectsLiveData.postValue(true)
    }

}