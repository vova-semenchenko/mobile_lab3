package com.example.lab3mobile.models

data class SettingWithSwitch(
    val title: String,
    val isChecked: Boolean) : ItemTypeInterface {

    override fun getItemType(): Int {
        return ItemTypeInterface.settingWithSwitchType
    }
}

