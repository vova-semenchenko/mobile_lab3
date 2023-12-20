package com.example.lab3mobile

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab3mobile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var dataModel: SettingViewModel


    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataModel = ViewModelProvider(this)[SettingViewModel::class.java]

        binding.recycleView.layoutManager = LinearLayoutManager(this)

        binding.button.setOnClickListener  {
            val newSetting = Setting("New Title", "New Description")
            dataModel.addSetting(newSetting)
        }

        var adapter = SettingAdapter(dataModel.getList)
        binding.recycleView.adapter = adapter

        dataModel.getList.observe(this ) {
            adapter.notifyDataSetChanged()
        }
    }
}