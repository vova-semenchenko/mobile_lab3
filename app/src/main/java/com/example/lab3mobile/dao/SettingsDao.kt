package com.example.lab3mobile.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.lab3mobile.model.ConfigurationSetting
import com.example.lab3mobile.model.Setting

@Dao
interface SettingsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSetting(setting: Setting)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSettings(settings: List<Setting>)

    @Update
    suspend fun updateSetting(setting: Setting)

    @Query("SELECT * FROM settings")
    suspend fun getAllSettings(): List<Setting>

    @Query("DELETE FROM settings")
    suspend fun deleteSettings()

    @Delete
    suspend fun deleteSettingItem(setting: Setting)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertConfigurationSetting(configurationSetting: ConfigurationSetting)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertConfigurationsSettings(configurationSettings: List<ConfigurationSetting>)

    @Update
    suspend fun updateConfigurationSetting(configurationSetting: ConfigurationSetting)

    @Query("SELECT * FROM configuration_settings")
    suspend fun getAllConfigurationsSettings(): List<ConfigurationSetting>

    @Query("DELETE FROM configuration_settings")
    suspend fun deleteConfigurationsSettings()

    @Delete
    suspend fun deleteConfigurationSettingItem(setting: ConfigurationSetting)
}