package com.example.foodorderapp.repositories

import com.example.foodorderapp.network.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val apiService: ApiService)
{
}