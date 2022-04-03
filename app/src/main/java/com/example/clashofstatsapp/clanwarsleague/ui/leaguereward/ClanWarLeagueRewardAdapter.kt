package com.example.clashofstatsapp.clanwarsleague.ui.leaguereward

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.clashofstatsapp.clanwarsleague.domain.ClanWarLeagueRewardItem
import com.example.clashofstatsapp.core.adapter.DataClassDiffCallback
import com.example.clashofstatsapp.databinding.ItemClanLeagueRewardBinding

class ClanWarLeagueRewardAdapter :
    ListAdapter<ClanWarLeagueRewardItem, ClanWarLeagueRewardAdapter.ClanLeagueRewardItemViewHolder>(DataClassDiffCallback {
        it.title
    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClanLeagueRewardItemViewHolder {
        val binding = ItemClanLeagueRewardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClanLeagueRewardItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ClanLeagueRewardItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ClanLeagueRewardItemViewHolder(
        private val binding: ItemClanLeagueRewardBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ClanWarLeagueRewardItem) {
            binding.textViewTitle.text = item.title
            binding.textViewReward.text = item.reward.toString()
        }
    }
}