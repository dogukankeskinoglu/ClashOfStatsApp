package com.example.clashofstatsapp.builderbase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.clashofstatsapp.databinding.FragmentBuilderBaseLevelBinding

class BuilderBaseLevelFragment : Fragment() {

    private var _binding: FragmentBuilderBaseLevelBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentBuilderBaseLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}