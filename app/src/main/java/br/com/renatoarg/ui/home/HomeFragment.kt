package br.com.renatoarg.ui.home

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import br.com.renatoarg.R
import br.com.renatoarg.model.pojo.User
import br.com.renatoarg.ui.home.adapter.UsersListAdapter
import br.com.renatoarg.ui.home.adapter.viewholder.UsersListInterface
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.item_user.*
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
        viewModel.getState().observe(viewLifecycleOwner, Observer { homeState ->
            handleHomeState(homeState)
        })
        users.adapter = usersListAdapter
    }

    private fun handleHomeState(homeState: HomeState) {
        Timber.d("HomeState: $homeState")
        when (homeState) {
            is HomeState.Init -> setupForInit()
            is HomeState.UsersLoaded -> setupForUsersLoaded(homeState.usersList)
            is HomeState.NavigateToUserDetail -> navigateToUserDetail()
        }
    }

    private fun setupForUsersLoaded(usersList: List<User>) {
        usersListAdapter.updateUsers(usersList)
    }

    private fun setupForInit() {
        viewModel.getUsers().observe(viewLifecycleOwner, Observer{ homeState ->
            handleHomeState(homeState)
        })
    }

    override fun selectUser(user: User, photo: ImageView) {
        viewModel.selectUser(user, photo)
    }

    private fun navigateToUserDetail() {
        val action = HomeFragmentDirections.actionHomeFragmentToOtherFragment()
        findNavController().navigate(action)
    }

}
