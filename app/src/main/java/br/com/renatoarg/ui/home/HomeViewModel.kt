package br.com.renatoarg.ui.home

import android.widget.ImageView
import androidx.lifecycle.*
import br.com.renatoarg.model.ReqresRepository
import br.com.renatoarg.model.pojo.User
import kotlinx.coroutines.Dispatchers

class HomeViewModel(private val repository: ReqresRepository) : ViewModel(), LifecycleObserver {

    private val homeLiveData = MutableLiveData<HomeState>()

    init {
        homeLiveData.apply {
            value = HomeState.Init
        }
    }

    fun getState() : LiveData<HomeState> {
        return homeLiveData
    }

    fun getUsers() = liveData(Dispatchers.IO) {
        val response = repository.getUsers()
        emit(HomeState.UsersLoaded(response.data))
    }

    fun selectUser(user: User, photo: ImageView) {
        homeLiveData.value = HomeState.NavigateToUserDetail(photo)
        homeLiveData.value = HomeState.SelectUser(user)
    }

}