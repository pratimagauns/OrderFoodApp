package com.pratima.foodorderapp.di.module

import com.pratima.foodorderapp.ui.activities.ForgotPasswordActivity
import com.pratima.foodorderapp.ui.activities.LoginActivity
import com.pratima.foodorderapp.ui.activities.OTPVerificationActivity
import com.pratima.foodorderapp.ui.activities.SignUpActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    internal abstract fun loginActivity(): LoginActivity

    @ContributesAndroidInjector
    internal abstract fun OTPVerificationActivity(): OTPVerificationActivity

    @ContributesAndroidInjector
    internal abstract fun SignUpActivity(): SignUpActivity

    @ContributesAndroidInjector
    internal abstract fun ForgotPasswordActivity(): ForgotPasswordActivity
}