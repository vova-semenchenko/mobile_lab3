package com.example.lab3mobile.repository

import com.example.lab3mobile.api.Api
import com.example.lab3mobile.api.RetrofitClient
import com.example.lab3mobile.dao.SettingsDao
import com.example.lab3mobile.model.ConfigurationSetting
import com.example.lab3mobile.model.Setting

class Repository(private val settingDao: SettingsDao) {

    private val retrofitClient = RetrofitClient.getClient()
    private val api = retrofitClient.create(Api::class.java)

    suspend fun loadSettings(): List<Setting>? {
        val response = api.getAllSettings()
        return if (response.isSuccessful) {
            response.body()
        }
        else {
            null
        }
    }

    suspend fun loadSettingById(id: Long): Setting? {
        val response = api.getSettingById(id)
        return if (response.isSuccessful) {
            response.body()
        }
        else {
            null
        }
    }

    suspend fun loadConfigurationSettings(): List<ConfigurationSetting>? {
        val response = api.getAllConfigurationsSettings()
        return if (response.isSuccessful) {
            response.body()
        }
        else {
            null
        }
    }

    suspend fun insertSetting(setting: Setting) {
        return settingDao.insertSetting(setting)
    }

    suspend fun insertSettings(settings: List<Setting>) {
        return settingDao.insertSettings(settings)
    }

    suspend fun updateSetting(setting: Setting) {
        settingDao.updateSetting(setting)
    }

    suspend fun getAllSettings(): List<Setting> {
        return settingDao.getAllSettings()
    }

    suspend fun clearSettings() {
        settingDao.deleteSettings()
    }

    suspend fun deleteSettingItem(setting: Setting) {
        settingDao.deleteSettingItem(setting)
    }

    suspend fun insertConfigurationSetting(configurationSetting: ConfigurationSetting) {
        return settingDao.insertConfigurationSetting(configurationSetting)
    }

    suspend fun insertConfigurationSettings(configurationSettings: List<ConfigurationSetting>) {
        return settingDao.insertConfigurationsSettings(configurationSettings)
    }

    suspend fun updateConfigurationSetting(configurationSetting: ConfigurationSetting) {
        settingDao.updateConfigurationSetting(configurationSetting)
    }

    suspend fun getAllConfigurationSettings(): List<ConfigurationSetting> {
        return settingDao.getAllConfigurationsSettings()
    }

    suspend fun clearConfigurationSettings() {
        settingDao.deleteConfigurationsSettings()
    }

    suspend fun deleteConfigurationSettingItem(configurationSetting: ConfigurationSetting) {
        settingDao.deleteConfigurationSettingItem(configurationSetting)
    }
}