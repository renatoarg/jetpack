package br.com.renatoarg.ui.home

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import br.com.renatoarg.R
import br.com.renatoarg.domain.model.User
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

        get_user_not_found.setOnClickListener {
            viewModel.getUser()
        }

        register.setOnClickListener {
            viewModel.registerUser()
        }
    }

    private fun handleHomeState(homeState: HomeState) {
        Timber.d("HomeState: $homeState")
        progressBar(homeState is HomeState.Loading)
        when(homeState) {
            is HomeState.Init -> setupForInit()
            is HomeState.Navigate -> navigateToOther()
            is HomeState.ErrorOnRegister -> showErrorOnRegister(homeState.e)
            is HomeState.UsersLoaded -> setupForUsersLoaded()
            is HomeState.UserLoaded -> setupForUserLoaded(homeState.user)
            is HomeState.UserRegistered -> setupForUserRegistered(homeState.user)
        }
    }

    private fun progressBar(isLoading : Boolean) {
        progress_circular.visibility = if (isLoading) VISIBLE else GONE
    }

    private fun showErrorOnRegister(e: Exception) {
        Toast.makeText(requireContext(), e.message, Toast.LENGTH_LONG).show()
    }

    private fun setupForUsersLoaded() {
        Toast.makeText(requireContext(), "Users loaded", Toast.LENGTH_LONG).show()
    }

    private fun setupForUserLoaded(user : User) {
        Toast.makeText(requireContext(), "Say Hello to ${user.firstName}", Toast.LENGTH_LONG).show()
    }

    private fun setupForUserRegistered(user : User) {
        Toast.makeText(requireContext(), "Registered user with id: ${user.id}", Toast.LENGTH_LONG).show()
    }

    private fun navigateToOther() {
        val action = HomeFragmentDirections.actionHomeFragmentToOtherFragment()
        findNavController().navigate(action)
    }

    private fun setupForInit() {
        Toast.makeText(requireContext(), "Init", Toast.LENGTH_LONG).show()
    }
}
