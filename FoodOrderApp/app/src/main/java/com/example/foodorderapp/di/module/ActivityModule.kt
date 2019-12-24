package com.persistent.cardamageapplication.di.module

import com.example.foodorderapp.ui.activities.LoginActivity
import com.example.foodorderapp.ui.activities.OTPVerificationActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    internal abstract fun loginActivity(): LoginActivity

    @ContributesAndroidInjector
    internal abstract fun OTPVerificationActivity(): OTPVerificationActivity

}