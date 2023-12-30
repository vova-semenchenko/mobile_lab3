package com.example.lab3mobile.api

import com.example.lab3mobile.model.ConfigurationSetting
import com.example.lab3mobile.model.Setting
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
        @GET("settings")
        suspend fun getAllSettings() : Response<List<Setting>>

        @GET("settings/{id}")
        suspend fun getSettingById(@Path("id") id: Long) : Response<Setting>

        @GET("configurationSettings")
        suspend fun getAllConfigurationsSettings() : Response<List<ConfigurationSetting>>
}