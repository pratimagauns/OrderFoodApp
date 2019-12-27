package com.pratima.foodorderapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.pratima.foodorderapp.R
import com.pratima.foodorderapp.databinding.ActivityForgotPasswordBinding
import com.pratima.foodorderapp.databinding.ActivitySignUpBinding
import com.pratima.foodorderapp.ui.viewmodel.LoginViewModel
import com.pratima.foodorderapp.ui.viewmodel.ViewModelFactory
import dagger.android.AndroidInjection
import javax.inject.Inject

class ForgotPasswordActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var binding: ActivityForgotPasswordBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_forgot_password)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)
        binding.viewModel = viewModel
    }
}
