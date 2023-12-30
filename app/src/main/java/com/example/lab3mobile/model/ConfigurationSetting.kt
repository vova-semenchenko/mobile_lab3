package com.example.lab3mobile.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "configuration_settings")
data class ConfigurationSetting(

    @field:Json(name = "title")
    @ColumnInfo(name = "title")
    val title: String?,

    @field:Json(name = "is_checked")
    @ColumnInfo(name = "is_checked")
    var isChecked: Boolean) : ItemTypeInterface {

    @field:Json(name = "id")
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_configuration")
    var idConfiguration: Long = 0

    override fun getItemType(): Int {
        return ItemTypeInterface.settingWithSwitchType
    }
}

