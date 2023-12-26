package com.example.lab3mobile.models

data class Setting(
    val title: String,
    val description: String) : ItemTypeInterface {
    override fun getItemType(): Int {
        return ItemTypeInterface.settingType
    }
}
