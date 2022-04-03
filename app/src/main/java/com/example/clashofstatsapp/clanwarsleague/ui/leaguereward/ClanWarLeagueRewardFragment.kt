package com.example.clashofstatsapp.clanwarsleague.ui.leaguereward

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.clashofstatsapp.R
import com.example.clashofstatsapp.clanwarsleague.ui.ClanWarLeaguesViewModel
import com.example.clashofstatsapp.core.adapter.VerticalSpacingItemDecoration
import com.example.clashofstatsapp.databinding.FragmentClanWarLeagueRewardBinding
import com.example.clashofstatsapp.infra.BaseFragment

class ClanWarLeagueRewardFragment : BaseFragment() {

    private val args: ClanWarLeagueRewardFragmentArgs by navArgs()

    private val adapter: ClanWarLeagueRewardAdapter by lazy(LazyThreadSafetyMode.NONE) {
        ClanWarLeagueRewardAdapter()
    }

    private val viewModel: ClanWarLeaguesViewModel by viewModels()

    private var _binding: FragmentClanWarLeagueRewardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentClanWarLeagueRewardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setUpView() {
        with(binding) {
            recylerViewReward.adapter = adapter
            adapter.submitList(viewModel.fetchClanWarLeaguesReward(args.rewardArg.id))
            textViewTitle.text = args.rewardArg.title
            recylerViewReward.addItemDecoration(
                VerticalSpacingItemDecoration(
                    firstItemTopSpacing = resources.getDimensionPixelSize(R.dimen.home_item_vertical_spacing),
                    betweenItemsSpacing = resources.getDimensionPixelSize(R.dimen.home_item_vertical_spacing),
                    lastItemBottomSpacing = resources.getDimensionPixelSize(R.dimen.home_item_vertical_spacing),
                    edgeSpacing = resources.getDimensionPixelSize(R.dimen.home_item_vertical_spacing)
                )
            )
        }
    }
}