package com.example.lab3mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab3mobile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = SettingAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycleView.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.recycleView.adapter = adapter

        val settingsTitles: Array<String> = resources.getStringArray(R.array.settings_titles)
        val settingsDescriptions: Array<String> = resources.getStringArray(R.array.settings_descriptions)
        for (i in settingsTitles.indices) {
            val setting = Setting(settingsTitles[i], settingsDescriptions[i])
            adapter.addSettingItem(setting)
        }
    }
}