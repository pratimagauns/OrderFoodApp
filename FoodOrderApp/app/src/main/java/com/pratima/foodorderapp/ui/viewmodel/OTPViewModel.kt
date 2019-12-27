package com.pratima.foodorderapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pratima.foodorderapp.repositories.UserRepository
import javax.inject.Inject

class OTPViewModel @Inject constructor(private val repository: UserRepository) : ViewModel(){
    var otpLiveData = MutableLiveData<Int>()
    var otpValue: Int = 0

}