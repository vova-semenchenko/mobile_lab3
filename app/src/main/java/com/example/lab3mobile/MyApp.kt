package com.example.lab3mobile

import android.app.Application
import com.example.lab3mobile.database.AppDataBase
import com.example.lab3mobile.repository.Repository

class MyApp : Application() {
    private val appDataBase by lazy { AppDataBase.getDatabase(this) }
    val appRepository by lazy { Repository(appDataBase.settingsDao()) }
}