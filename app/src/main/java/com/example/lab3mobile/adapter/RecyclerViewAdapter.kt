package com.example.lab3mobile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.lab3mobile.databinding.ConfigurationSettingItemBinding
import com.example.lab3mobile.databinding.SettingsItemBinding
import com.example.lab3mobile.model.ItemTypeInterface
import com.example.lab3mobile.model.Setting
import com.example.lab3mobile.model.ConfigurationSetting
import kotlin.math.absoluteValue

class RecyclerViewAdapter(
    private val settingsList: LiveData<List<ItemTypeInterface>>,
    private var onClickListener: OnClickListener)
    : RecyclerView.Adapter<RecyclerViewAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {

        return when(viewType){
            ItemTypeInterface.settingType -> SettingHolder(
                SettingsItemBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )
            else -> ConfigurationSettingHolder(
                ConfigurationSettingItemBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return settingsList.value!!.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(settingsList.value!![position], onClickListener)
    }

    override fun getItemViewType(position: Int): Int {
        return settingsList.value!![position].getItemType()
    }

    abstract class MyHolder(itemBinding: ViewBinding) : RecyclerView.ViewHolder(itemBinding.root){
        abstract fun bind(item: ItemTypeInterface, onClickListener: OnClickListener)
    }

    class SettingHolder(private val itemBinding: SettingsItemBinding) : MyHolder(itemBinding) {
        override fun bind(item: ItemTypeInterface, onClickListener: OnClickListener) = with(itemBinding){
            item as Setting
            titleView.text = item.title
            descriptionView.text = item.description
            deleteButton.setOnClickListener { onClickListener.onClick(item) }
        }
    }

    class ConfigurationSettingHolder(private val itemBinding: ConfigurationSettingItemBinding) : MyHolder(itemBinding) {
        override fun bind(item: ItemTypeInterface, onClickListener: OnClickListener) = with(itemBinding) {
            item as ConfigurationSetting
            titleView.text = item.title
            switchButton.isChecked = item.isChecked
            switchButton.setOnClickListener { onClickListener.onClick(item) }
        }
    }
}