package com.example.clashofstatsapp.clanwarsleague.ui.leagues

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.clashofstatsapp.R
import com.example.clashofstatsapp.clanwarsleague.domain.ClanWarLeagueItem
import com.example.clashofstatsapp.clanwarsleague.ui.ClanWarLeaguesViewModel
import com.example.clashofstatsapp.clanwarsleague.ui.ClansLeagueEvent
import com.example.clashofstatsapp.clanwarsleague.ui.leaguereward.ClanWarLeagueRewardArguments
import com.example.clashofstatsapp.core.adapter.VerticalSpacingItemDecoration
import com.example.clashofstatsapp.databinding.FragmentClanWarLeaguesBinding
import com.example.clashofstatsapp.home.ui.HomeInfoFragmentDirections
import com.example.clashofstatsapp.infra.BaseFragment
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.Locale

class ClanWarLeaguesFragment : BaseFragment() {

    private val args: ClanWarLeaguesFragmentArgs by navArgs()

    private val adapter: ClanWarLeaguesAdapter by lazy(LazyThreadSafetyMode.NONE) {
        ClanWarLeaguesAdapter(::setOnItemClickListener)
    }

    private val viewModel: ClanWarLeaguesViewModel by viewModels()

    private var _binding: FragmentClanWarLeaguesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentClanWarLeaguesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
        viewModel.eventsFlow
            .onEach { event ->
                when (event) {
                    is ClansLeagueEvent.NavigateLeagueReward -> {
                        val args = ClanWarLeagueRewardArguments(id = event.item.id, title = event.item.text)
                        val navDirections = ClanWarLeaguesFragmentDirections.navigateToLeagueReward(rewardArg = args)
                        navigatePage(navDirections)
                    }
                }
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun setUpView() {
        with(binding) {
            binding.textViewTitle.text = args.titleArg.uppercase(Locale.ENGLISH)
            recyclerViewLeague.adapter = adapter
            adapter.submitList(viewModel.fetchClanWarLeagues())
            recyclerViewLeague.addItemDecoration(
                VerticalSpacingItemDecoration(
                    firstItemTopSpacing = resources.getDimensionPixelSize(R.dimen.home_item_vertical_spacing),
                    betweenItemsSpacing = resources.getDimensionPixelSize(R.dimen.home_item_vertical_spacing),
                    lastItemBottomSpacing = resources.getDimensionPixelSize(R.dimen.home_item_vertical_spacing),
                    edgeSpacing = resources.getDimensionPixelSize(R.dimen.home_item_vertical_spacing)
                )
            )
        }
    }

    private fun setOnItemClickListener(item: ClanWarLeagueItem) {
        viewModel.onItemClickListener(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}