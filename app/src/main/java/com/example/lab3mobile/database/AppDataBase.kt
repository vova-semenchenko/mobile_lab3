package com.example.lab3mobile.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lab3mobile.dao.SettingsDao
import com.example.lab3mobile.model.ConfigurationSetting
import com.example.lab3mobile.model.Setting


@Database(
    entities = [
        Setting::class,
        ConfigurationSetting::class,
    ],
    version = 2,
    exportSchema = false
)

abstract class AppDataBase : RoomDatabase(){
    abstract fun settingsDao(): SettingsDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            return INSTANCE ?: synchronized(this) {
                val db = Room.databaseBuilder(
                    context,
                    AppDataBase::class.java,
                    "settings_db.db3"
                ).build()
                INSTANCE = db
                db
            }
        }
    }
}