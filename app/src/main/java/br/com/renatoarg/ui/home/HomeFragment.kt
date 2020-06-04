package br.com.renatoarg.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import br.com.renatoarg.R
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("onViewCreated:")

        viewModel.getState().observe(viewLifecycleOwner, Observer{homeState ->
            handleHomeState(homeState)
        })

        navigate.setOnClickListener {
            viewModel.navigate()
        }

        request.setOnClickListener {
            viewModel.getUsers()
        }
    }

    private fun handleHomeState(homeState: HomeState) {
        Timber.d("HomeState: $homeState")
        when(homeState) {
            is HomeState.Init -> setupForInit()
            is HomeState.Navigate -> navigateToOther()
            is HomeState.UsersLoaded -> setupForUsersLoaded()
        }
    }

    private fun setupForUsersLoaded() {
        Toast.makeText(requireContext(), "Users loaded", Toast.LENGTH_LONG).show()
    }

    private fun navigateToOther() {
        val action = HomeFragmentDirections.actionHomeFragmentToOtherFragment()
        findNavController().navigate(action)
    }

    private fun setupForInit() {
        Toast.makeText(requireContext(), "Init", Toast.LENGTH_LONG).show()
    }
}
