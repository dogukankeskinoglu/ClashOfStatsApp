package com.example.clashofstatsapp.home.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.clashofstatsapp.core.adapter.DataClassDiffCallback
import com.example.clashofstatsapp.databinding.HomeInfoItemBinding
import com.example.clashofstatsapp.home.domain.HomeInfoItem

class HomeItemAdapter (
    private val onItemClickListener: (Int) -> Unit = {}
    ): ListAdapter<HomeInfoItem, HomeItemAdapter.HomeItemViewHolder>(DataClassDiffCallback {
    it.id
}) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeItemViewHolder {
        val binding = HomeInfoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeItemViewHolder(binding, onItemClickListener)
    }

    override fun onBindViewHolder(holder: HomeItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class HomeItemViewHolder(
        private val binding: HomeInfoItemBinding,
        private val onItemClickListener: (Int) -> Unit = {}
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.textViewTitle.setOnClickListener {
                val item = this.adapterPosition
                onItemClickListener.invoke(item)
            }
        }

        fun bind(item: HomeInfoItem) {
            binding.textViewTitle.text = item.text
        }
    }
}

