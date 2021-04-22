package com.pamungkasandono.android3appacademy.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pamungkasandono.android3appacademy.data.ModuleEntity
import com.pamungkasandono.android3appacademy.databinding.ItemsModuleListBinding

class DetailCourseAdapter : RecyclerView.Adapter<DetailCourseAdapter.ModuleViewHolder>() {
    private val listModules = ArrayList<ModuleEntity>()

    fun setModule(module: List<ModuleEntity>?) {
        if (module == null) return
        this.listModules.clear()
        this.listModules.addAll(module)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleViewHolder {
        val itemModuleListBinding =
            ItemsModuleListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ModuleViewHolder(itemModuleListBinding)
    }

    override fun onBindViewHolder(holder: ModuleViewHolder, position: Int) {
        val course = listModules[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int = listModules.size

    inner class ModuleViewHolder(private val binding: ItemsModuleListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(module: ModuleEntity) {
            binding.textModuleTitle.text = module.title
        }
    }
}