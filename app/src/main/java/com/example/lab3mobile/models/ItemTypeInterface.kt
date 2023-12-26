package com.example.lab3mobile.models

interface ItemTypeInterface {

    fun getItemType(): Int

    companion object{
        const val settingType: Int = 1
        const val settingWithSwitchType: Int = 2
    }
}