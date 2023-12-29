package com.example.lab3mobile

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab3mobile.adapter.OnClickListener
import com.example.lab3mobile.adapter.RecyclerViewAdapter
import com.example.lab3mobile.databinding.ActivityMainBinding
import com.example.lab3mobile.model.ConfigurationSetting
import com.example.lab3mobile.model.ItemTypeInterface
import com.example.lab3mobile.model.Setting

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var dataModel: SettingViewModel


    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application))[SettingViewModel::class.java]

        binding.recycleView.layoutManager = LinearLayoutManager(this)

        var index = 0
        binding.addButton.setOnClickListener  {

            if(index % 2 == 0) {
                val newSetting = Setting(
                    title = "New Title - ${index++}",
                    description = "New Description"
                )
                dataModel.addSetting(newSetting)
            }
            else {
                val newConfigureSettings = ConfigurationSetting(
                    title = "New Title - ${index++}",
                    isChecked = false
                )
                dataModel.addConfigurationSetting(newConfigureSettings)
            }
        }


        val onClick = object : OnClickListener {
            override fun onClick(item: ItemTypeInterface) {
                when (item) {
                    is Setting -> {
                        dataModel.deleteSettingItem(item)
                    }
                    is ConfigurationSetting -> {
                        dataModel.updateConfigurationSetting(item)
                    }
                }
            }
        }


        val adapter = RecyclerViewAdapter(dataModel.getList, onClick)
        binding.recycleView.adapter = adapter

        dataModel.getList.observe(this ) {
            adapter.notifyDataSetChanged()
        }
    }
}