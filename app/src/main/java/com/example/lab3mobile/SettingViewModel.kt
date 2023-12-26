package com.example.lab3mobile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab3mobile.models.ItemTypeInterface
import com.example.lab3mobile.models.Setting
import com.example.lab3mobile.models.SettingWithSwitch

class SettingViewModel : ViewModel(){
    private var _myList: MutableLiveData<List<ItemTypeInterface>> =
        MutableLiveData<List<ItemTypeInterface>>().apply {
        value = emptyList()
    }

//    private val settingsList = listOf(
//        Setting("Networks & Internet", "Mobile, Wi-Fi, hotspot"),
//        Setting("Connected Device", "Bluetooth, pairing"),
//        Setting("Apps", "Assistant, recent apps, default apps"),
//        Setting("Notifications", "Notification history, conversations"),
//        Setting("Battery", "72% - Until 12:45 PM"),
//        Setting("Storage", "19% - 207 GB free"),
//        Setting("Sounds & Vibration", "Volume, haptics, Do  Not Disturb")
//    )


    private val settingsList = listOf(
        Setting("Networks & Internet", "Mobile, Wi-Fi, hotspot"),
        Setting("Connected Device", "Bluetooth, pairing"),
        Setting("Apps", "Assistant, recent apps, default apps"),
        SettingWithSwitch("Notifications", false),
        Setting("Battery", "72% - Until 12:45 PM"),
        SettingWithSwitch("Storage", true),
        Setting("Sounds & Vibration", "Volume, haptics, Do  Not Disturb")
    )
    init {
        _myList.value = settingsList
    }

    val getList: LiveData<List<ItemTypeInterface>> = _myList

    fun addSetting(value: ItemTypeInterface){
        _myList.value = _myList.value?.plus(value)
    }
}