package com.example.lab3mobile.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "configuration_settings")
data class ConfigurationSetting(

    @ColumnInfo(name = "title")
    val title: String?,

    @ColumnInfo(name = "is_checked")
    var isChecked: Boolean) : ItemTypeInterface {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_configuration")
    var idConfiguration: Long = 0

    override fun getItemType(): Int {
        return ItemTypeInterface.settingWithSwitchType
    }
}

