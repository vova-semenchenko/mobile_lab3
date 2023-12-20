package com.example.lab3mobile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3mobile.databinding.SettingsItemBinding

class SettingAdapter(private val settingsList: LiveData<List<Setting>>): RecyclerView.Adapter<SettingAdapter.SettingHolder>() {

    class SettingHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = SettingsItemBinding.bind(item)
        fun bind(setting: Setting) = with(binding) {
            titleView.text = setting.title
            descrioptionView.text = setting.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.settings_item, parent, false)
        return SettingHolder(view)
    }

    override fun getItemCount(): Int {
        return settingsList.value!!.size
    }

    override fun onBindViewHolder(holder: SettingHolder, position: Int) {
        holder.bind(settingsList.value!![position])
    }
}