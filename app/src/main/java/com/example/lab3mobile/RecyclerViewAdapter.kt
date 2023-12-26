package com.example.lab3mobile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.lab3mobile.databinding.SettingWithToggleItemBinding
import com.example.lab3mobile.databinding.SettingsItemBinding
import com.example.lab3mobile.models.ItemTypeInterface
import com.example.lab3mobile.models.Setting
import com.example.lab3mobile.models.SettingWithSwitch

class RecyclerViewAdapter(private val settingsList: LiveData<List<ItemTypeInterface>>): RecyclerView.Adapter<RecyclerViewAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {



        return when(viewType){
            ItemTypeInterface.settingType -> SettingHolder(
                SettingsItemBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )
            else -> SettingWithSwitchHolder(
                SettingWithToggleItemBinding.inflate(
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
        holder.bind(settingsList.value!![position])
    }

    override fun getItemViewType(position: Int): Int {
        return settingsList.value!![position].getItemType()
    }

    abstract class MyHolder(itemBinding: ViewBinding) : RecyclerView.ViewHolder(itemBinding.root){
        abstract fun bind(item: ItemTypeInterface)
    }

    class SettingHolder(private val itemBinding: SettingsItemBinding) : MyHolder(itemBinding) {
        override fun bind(item: ItemTypeInterface) = with(itemBinding){
            item as Setting
            titleView.text = item.title
            descrioptionView.text = item.description
        }
    }

    class SettingWithSwitchHolder(private val itemBinding: SettingWithToggleItemBinding) : MyHolder(itemBinding) {
        override fun bind(item: ItemTypeInterface) = with(itemBinding) {
            item as SettingWithSwitch
            titleView.text = item.title
            switchButton.isChecked = item.isChecked
        }
    }
}