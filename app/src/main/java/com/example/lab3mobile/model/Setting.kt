package com.example.lab3mobile.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "settings")
data class Setting(

    @ColumnInfo(name = "title")
    val title: String?,

    @ColumnInfo(name = "description")
    val description: String?

) : ItemTypeInterface {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_setting")
    var idSetting: Long = 0

    override fun getItemType(): Int {
        return ItemTypeInterface.settingType
    }
}
