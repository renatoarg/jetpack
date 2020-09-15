package br.com.renatoarg.ui.other

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import br.com.renatoarg.R
import br.com.renatoarg.commons.PreferencesHelper
import br.com.renatoarg.ui.home.HomeState
import br.com.renatoarg.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_other.*
//import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import timber.log.Timber
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
@AndroidEntryPoint
class OtherFragment : Fragment(R.layout.fragment_other) {

    private val viewModel: HomeViewModel by activityViewModels()

    @Inject
    lateinit var preferences: PreferencesHelper

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getState().observe(viewLifecycleOwner, Observer { homeState ->
            handleHomeState(homeState)
        })

        viewModel.init()
    }

    private fun handleHomeState(homeState: HomeState) {
        Timber.d("HomeState: $homeState")
        when (homeState) {
            is HomeState.Init -> setupForInit()
            is HomeState.Loading -> setupForLoading()
        }
    }

    private fun setupForLoading() {
        Toast.makeText(requireContext(), "Loading", Toast.LENGTH_LONG).show()
    }

    private fun setupForInit() {
        otherName.text = preferences.getString("name")
    }

}
