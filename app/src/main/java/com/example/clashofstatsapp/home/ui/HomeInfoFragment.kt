package com.example.clashofstatsapp.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.clashofstatsapp.R
import com.example.clashofstatsapp.core.adapter.VerticalSpacingItemDecoration
import com.example.clashofstatsapp.databinding.FragmentInfoHomeBinding
import com.example.clashofstatsapp.home.domain.HomeInfoItem
import com.example.clashofstatsapp.infra.BaseFragment
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class HomeInfoFragment : BaseFragment() {

    private val adapter: HomeItemAdapter by lazy(LazyThreadSafetyMode.NONE) {
        HomeItemAdapter(::setHomeInfoItemClickListener)
    }

    private val viewModel: HomeInfoViewModel by viewModels()

    private var _binding: FragmentInfoHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentInfoHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        viewModel.eventsFlow
            .onEach { event ->
                when (event) {
                    is HomeInfoEvent.NavigateHomeVillage -> {
                        val navDirections = HomeInfoFragmentDirections.navigateToHomeVillage()
                        navigatePage(navDirections)
                    }
                    is HomeInfoEvent.NavigateBuilderBaseVillage -> {
                        val navDirections = HomeInfoFragmentDirections.navigateToBuilderBase()
                        navigatePage(navDirections)
                    }
                    is HomeInfoEvent.NavigateClansLeague -> {
                        val navDirections = HomeInfoFragmentDirections.navigateToClansLeague(titleArg = event.title)
                        navigatePage(navDirections)
                    }
                }
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupView() {
        with(binding) {
            recyclerViewInfo.adapter = adapter
            adapter.submitList(viewModel.getHomeInfoItems())
            recyclerViewInfo.addItemDecoration(
                VerticalSpacingItemDecoration(
                    firstItemTopSpacing = resources.getDimensionPixelSize(R.dimen.home_item_vertical_spacing),
                    betweenItemsSpacing = resources.getDimensionPixelSize(R.dimen.home_item_vertical_spacing),
                    lastItemBottomSpacing = resources.getDimensionPixelSize(R.dimen.home_item_vertical_spacing),
                    edgeSpacing = resources.getDimensionPixelSize(R.dimen.home_item_vertical_spacing)
                )
            )
        }
    }

    private fun setHomeInfoItemClickListener(item: HomeInfoItem) {
        viewModel.onItemClickListener(item)
    }
}