package br.com.renatoarg.ui.other

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.transition.TransitionInflater
import br.com.renatoarg.R
import br.com.renatoarg.model.pojo.User
import br.com.renatoarg.ui.home.HomeState
import br.com.renatoarg.ui.home.HomeViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.fragment_user_detail.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class UserDetailFragment : Fragment(R.layout.fragment_user_detail) {

    private val viewModel: HomeViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getState().observe(viewLifecycleOwner, Observer { homeState ->
            handleHomeState(homeState)
        })
    }

    private fun handleHomeState(homeState: HomeState) {
        Timber.d("HomeState: $homeState")
        when (homeState) {
            is HomeState.SelectUser -> setupForSelectedUser(homeState.user)
        }
    }

    private fun setupForSelectedUser(user: User) {
        email.setText(user.email)
        firstName.setText(user.first_name)
        lastName.setText(user.last_name)
        Glide.with(requireContext()).load(user.avatar).apply(RequestOptions().circleCrop())
            .into(photo)
    }
}
