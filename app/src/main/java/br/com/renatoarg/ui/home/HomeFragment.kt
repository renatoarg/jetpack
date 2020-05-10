package br.com.renatoarg.ui.home

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

import br.com.renatoarg.R
import br.com.renatoarg.model.pojo.User
import br.com.renatoarg.ui.home.adapter.UsersListAdapter
import br.com.renatoarg.ui.home.adapter.viewholder.UsersListInterface
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(R.layout.fragment_home), UsersListInterface {

    private val viewModel: HomeViewModel by sharedViewModel()
    private lateinit var usersListAdapter : UsersListAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        usersListAdapter = UsersListAdapter(context, emptyList(), this)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getState().observe(viewLifecycleOwner, Observer{homeState ->
            handleHomeState(homeState)
        })
        viewModel.getUsers()
        users.adapter = usersListAdapter
    }

    private fun handleHomeState(homeState: HomeState) {
        Timber.d("HomeState: $homeState")
        when(homeState) {
            is HomeState.Init -> setupForInit()
            is HomeState.Navigate -> navigateToOther()
            is HomeState.UsersLoaded -> setupForUsersLoaded(homeState.usersList)
        }
    }

    private fun setupForUsersLoaded(usersList: List<User>) {
        usersListAdapter.updateUsers(usersList)
    }

    private fun navigateToOther() {
        val action = HomeFragmentDirections.actionHomeFragmentToOtherFragment()
        findNavController().navigate(action)
    }

    private fun setupForInit() {
        Toast.makeText(requireContext(), "Init", Toast.LENGTH_LONG).show()
    }

    override fun selectUser(user: User, photo: ImageView) {
//        viewModel.selectUser(user, photo)
    }
}
