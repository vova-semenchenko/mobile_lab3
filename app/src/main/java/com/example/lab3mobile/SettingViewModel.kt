package com.example.lab3mobile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SettingViewModel : ViewModel(){
    private var _myList: MutableLiveData<List<Setting>> =
        MutableLiveData<List<Setting>>().apply {
        value = emptyList()
    }

    private val settingsList = listOf(
        Setting("Networks & Internet", "Mobile, Wi-Fi, hotspot"),
        Setting("Connected Device", "Bluetooth, pairing"),
        Setting("Apps", "Assistant, recent apps, default apps"),
        Setting("Notifications", "Notification history, conversations"),
        Setting("Battery", "72% - Until 12:45 PM"),
        Setting("Storage", "19% - 207 GB free"),
        Setting("Sounds & Vibration", "Volume, haptics, Do  Not Disturb")
    )

    init {
        _myList.value = settingsList
    }

    val getList: LiveData<List<Setting>> = _myList

    fun addSetting(value: Setting){
        _myList.value = _myList.value?.plus(value)
    }
}