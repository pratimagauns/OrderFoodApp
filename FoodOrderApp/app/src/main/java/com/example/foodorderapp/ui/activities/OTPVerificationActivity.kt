package com.example.foodorderapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.foodorderapp.R
import com.example.foodorderapp.databinding.ActivityLoginBinding
import com.example.foodorderapp.ui.viewmodel.LoginViewModel
import com.example.foodorderapp.ui.viewmodel.ViewModelFactory
import dagger.android.AndroidInjection
import javax.inject.Inject

class OTPVerificationActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_otpverification)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)
        binding.viewModel = viewModel
    }
}
