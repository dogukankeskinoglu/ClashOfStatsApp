package com.example.clashofstatsapp.clanwarsleague.ui.leagues

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.clashofstatsapp.clanwarsleague.domain.ClanWarLeagueItem
import com.example.clashofstatsapp.clanwarsleague.ui.leaguereward.ClanWarLeagueRewardArguments
import com.example.clashofstatsapp.core.adapter.DataClassDiffCallback
import com.example.clashofstatsapp.databinding.ItemClansLeagueBinding

class ClanWarLeaguesAdapter(
    private val onItemClickListener: (ClanWarLeagueItem) -> Unit = {}
) : ListAdapter<ClanWarLeagueItem, ClanWarLeaguesAdapter.ClansLeagueItemViewHolder>(DataClassDiffCallback {
    it.id
}) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClansLeagueItemViewHolder {
        val binding = ItemClansLeagueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClansLeagueItemViewHolder(binding, onItemClickListener)
    }

    override fun onBindViewHolder(holder: ClansLeagueItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ClansLeagueItemViewHolder(
        private val binding: ItemClansLeagueBinding,
        private val onItemClickListener: (ClanWarLeagueItem) -> Unit = {}
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.button.setOnClickListener {
                val item = getItem(adapterPosition)
                onItemClickListener.invoke(item)
            }
        }

        fun bind(itemWar: ClanWarLeagueItem) {
            binding.button.text = itemWar.text
        }
    }
}