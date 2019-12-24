package com.persistent.cardamageapplication.di.component

import android.app.Application
import com.example.foodorderapp.FoodOrderApplication
import com.persistent.cardamageapplication.di.module.ActivityModule
import com.persistent.cardamageapplication.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityModule::class])
interface AppComponent {
    fun inject(app: FoodOrderApplication)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): Builder
    }
}