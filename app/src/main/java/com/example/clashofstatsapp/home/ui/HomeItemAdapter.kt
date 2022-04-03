package com.example.clashofstatsapp.home.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.clashofstatsapp.core.adapter.DataClassDiffCallback
import com.example.clashofstatsapp.databinding.ItemHomeInfoBinding
import com.example.clashofstatsapp.home.domain.HomeInfoItem

class HomeItemAdapter(
    private val onItemClickListener: (HomeInfoItem) -> Unit = {}
) : ListAdapter<HomeInfoItem, HomeItemAdapter.HomeItemViewHolder>(DataClassDiffCallback {
    it.id
}) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeItemViewHolder {
        val binding = ItemHomeInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeItemViewHolder(binding, onItemClickListener)
    }

    override fun onBindViewHolder(holder: HomeItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class HomeItemViewHolder(
        private val binding: ItemHomeInfoBinding,
        private val onItemClickListener: (HomeInfoItem) -> Unit = {}
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.textViewTitle.setOnClickListener {
                onItemClickListener.invoke(getItem(adapterPosition))
            }
        }

        fun bind(item: HomeInfoItem) {
            binding.textViewTitle.text = item.text
        }
    }
}

