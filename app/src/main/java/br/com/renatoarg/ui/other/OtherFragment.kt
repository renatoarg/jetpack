package br.com.renatoarg.ui.other

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import br.com.renatoarg.R
import br.com.renatoarg.ui.home.HomeState
import br.com.renatoarg.ui.home.HomeViewModel
import br.com.renatoarg.ui.widget.*
import kotlinx.android.synthetic.main.fragment_other.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class OtherFragment : Fragment(R.layout.fragment_other), WidgetInterface {

    private val viewModel: HomeViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getState().observe(viewLifecycleOwner, Observer { homeState ->
            handleHomeState(homeState)
        })
        widged_other.addButton2CallBack(WidgetButton2CallBackAdapter(object :
            WidgetButton2CallBack {
            override fun onButton2Clicked() {
                Toast.makeText(requireContext(), "Button 2 clicked", Toast.LENGTH_SHORT).show()
            }
        }))
        widged_other.addButton3CallBack(WidgetButton3CallBackAdapter(object :
            WidgetButton3CallBack {
            override fun onButton3Clicked() {
                Toast.makeText(requireContext(), "Button 3 clicked", Toast.LENGTH_SHORT).show()
            }
        }))
        widged_other.showButton2()
        widged_other.showButton3()
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
        Toast.makeText(requireContext(), "Init", Toast.LENGTH_LONG).show()
    }

    override fun onButton1Clicked() {
        TODO("Not yet implemented")
    }

    override fun onButton2Clicked() {
        Toast.makeText(requireContext(), "Button 2 clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onButton3Clicked() {
        Toast.makeText(requireContext(), "Button 3 clicked", Toast.LENGTH_SHORT).show()
    }

}
