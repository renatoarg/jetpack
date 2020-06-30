package br.com.renatoarg.ui.home

import androidx.lifecycle.*
import br.com.renatoarg.domain.interactor.GetUserUseCase
import br.com.renatoarg.domain.interactor.ListUserUseCase
import br.com.renatoarg.domain.interactor.RegisterUserUseCase
import br.com.renatoarg.domain.repository.Resource
import kotlinx.coroutines.launch

class HomeViewModel(
    private val listUserUseCase: ListUserUseCase,
    private val getUserUseCase: GetUserUseCase,
    private val registerUserUseCase: RegisterUserUseCase
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

    fun getState(): LiveData<HomeState> {
        return homeLiveData
    }

    fun getUser() {
        viewModelScope.launch {
            when (val resource = getUserUseCase.execute()) {
                is Resource.Value -> homeLiveData.postValue(HomeState.UserLoaded(resource.value))
                is Resource.Error -> homeLiveData.postValue(HomeState.Error(resource.error))
            }
        }
    }

    fun registerUser() {
        viewModelScope.launch {
            homeLiveData.postValue(HomeState.Loading)
            val resource = registerUserUseCase
                .execute("sydney@test", null)
            when (resource) {
                is Resource.Value -> homeLiveData.postValue(HomeState.UserRegistered(resource.value))
                is Resource.Error -> homeLiveData.postValue(HomeState.ErrorOnRegister(resource.error))
            }
        }
    }

    fun getUsers() {
        viewModelScope.launch {
            when (val resource = listUserUseCase.execute()) {
                is Resource.Value -> homeLiveData.postValue(HomeState.UsersLoaded(resource.value))
                is Resource.Error -> homeLiveData.postValue(HomeState.Error(resource.error))
            }
        }
    }

    fun navigate() {
        homeLiveData.value = HomeState.Navigate
        homeLiveData.value = HomeState.Loading
    }
}