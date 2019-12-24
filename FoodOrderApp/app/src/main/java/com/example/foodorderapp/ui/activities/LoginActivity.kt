package com.example.foodorderapp.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.foodorderapp.R
import com.example.foodorderapp.databinding.ActivityLoginBinding
import com.example.foodorderapp.ui.viewmodel.LoginViewModel
import com.example.foodorderapp.ui.viewmodel.ViewModelFactory
import dagger.android.AndroidInjection
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)

        viewModel.projectsLiveData.observe(this, Observer<Boolean> { data ->
            val intent = Intent(this, OTPVerificationActivity::class.java)
            startActivity(intent)
        })

        binding.viewModel = viewModel
    }
}
