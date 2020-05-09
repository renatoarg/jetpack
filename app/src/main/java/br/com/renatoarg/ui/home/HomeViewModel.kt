package br.com.renatoarg.ui.home

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel(), LifecycleObserver {

    private val homeLiveData = MutableLiveData<HomeState>()

    init {
        homeLiveData.apply {
            value = HomeState.Init
        }
    }

    fun init() {
        homeLiveData.value = HomeState.Init
    }

    fun getState() : LiveData<HomeState> {
        return homeLiveData
    }

    fun doFakeRequest() {
        homeLiveData.value = HomeState.FakeRequest
        homeLiveData.value = HomeState.Loading
    }

}