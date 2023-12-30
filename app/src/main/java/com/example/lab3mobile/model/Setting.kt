package com.example.lab3mobile.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "settings")
data class Setting(

    @field:Json(name = "title")
    @ColumnInfo(name = "title")
    val title: String?,

    @field:Json(name = "description")
    @ColumnInfo(name = "description")
    val description: String?

) : ItemTypeInterface {

    @field:Json(name = "id")
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_setting")
    var idSetting: Long = 0

    override fun getItemType(): Int {
        return ItemTypeInterface.settingType
    }
}
