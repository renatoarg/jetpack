package br.com.renatoarg.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import br.com.renatoarg.domain.interactor.ListUserUseCase
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
    private val listUserUseCase: ListUserUseCase
) : ViewModel(), LifecycleObserver {

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

    fun getUsers() {
        viewModelScope.launch {
            try {
                val users = listUserUseCase.execute()
                homeLiveData.postValue(HomeState.UsersLoaded(users))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun navigate() {
        homeLiveData.value = HomeState.Navigate
        homeLiveData.value = HomeState.Loading
    }
}