package br.com.renatoarg.ui.other

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import br.com.renatoarg.R
import br.com.renatoarg.ui.home.HomeState
import br.com.renatoarg.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class OtherFragment : Fragment(R.layout.fragment_other) {

    private val viewModel: HomeViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getState().observe(viewLifecycleOwner, Observer {homeState ->
            handleHomeState(homeState)
        })
    }

    private fun handleHomeState(homeState: HomeState) {
        Timber.d("HomeState: $homeState")
        when(homeState) {
            is HomeState.Init -> setupForInit()
            is HomeState.Loading -> setupForLoading()
        }
    }

    private fun setupForLoading() {
        Toast.makeText(requireContext(), "Loading", Toast.LENGTH_LONG).show()
    }

    private fun setupForInit() {
        Toast.makeText(requireContext(), "Init", Toast.LENGTH_LONG).show()
    }

}
