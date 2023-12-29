package com.example.lab3mobile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.lab3mobile.model.ConfigurationSetting
import com.example.lab3mobile.model.ItemTypeInterface
import com.example.lab3mobile.model.Setting
import kotlinx.coroutines.launch

class SettingViewModel(application: Application) : AndroidViewModel(application){

    private val repository = (application as MyApp).appRepository

    private var _myList: MutableLiveData<List<ItemTypeInterface>> =
        MutableLiveData<List<ItemTypeInterface>>().apply {
        value = emptyList()
    }

    val getList: LiveData<List<ItemTypeInterface>> = _myList

    private val settingsList = listOf(
        Setting("Networks & Internet", "Mobile, Wi-Fi, hotspot"),
        Setting("Connected Device", "Bluetooth, pairing"),
        Setting("Apps", "Assistant, recent apps, default apps"),
        Setting("Battery", "72% - Until 12:45 PM"),
        Setting("Sounds & Vibration", "Volume, haptics, Do  Not Disturb")
    )

    private val configurationsList = listOf(
        ConfigurationSetting("Notifications", false),
        ConfigurationSetting("Storage", true),
    )


    init {
        viewModelScope.launch {
//            repository.clearSettings()
//            repository.clearConfigurationSettings()
//
//            settingsList.let {
//                repository.insertSettings(it)
//            }
//
//            configurationsList.let {
//                repository.insertConfigurationSettings(it)
//            }

            getLists()
        }
    }

    private fun getLists() = viewModelScope.launch {
        _myList.value = repository.getAllSettings().plus(repository.getAllConfigurationSettings())
    }

    fun addSetting(setting: Setting) = viewModelScope.launch {
        repository.insertSetting(setting)
        getLists()
    }

    fun addConfigurationSetting(configurationSetting: ConfigurationSetting) = viewModelScope.launch {
        repository.insertConfigurationSetting(configurationSetting)
        getLists()
    }

    fun deleteSettingItem(setting: Setting) = viewModelScope.launch {
        repository.deleteSettingItem(setting)
        getLists()
    }

    fun updateConfigurationSetting(configurationSetting: ConfigurationSetting) = viewModelScope.launch {
        configurationSetting.isChecked = !configurationSetting.isChecked
        repository.updateConfigurationSetting(configurationSetting)
        getLists()
    }
}