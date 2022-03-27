package com.example.clashofstatsapp.infra

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar

open class BaseFragment : Fragment() {

    fun showSnackBar(@StringRes resource: Int) {
        Snackbar.make(requireView(), resource, Snackbar.LENGTH_SHORT)
            .show()
    }

    fun navigatePage(navDirections: NavDirections) {
        findNavController().navigate(navDirections)
    }
}