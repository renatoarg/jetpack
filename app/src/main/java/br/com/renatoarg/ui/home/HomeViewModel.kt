package br.com.renatoarg.ui.home

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.renatoarg.model.ReqresRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeViewModel(private val repository: ReqresRepository) : ViewModel(), LifecycleObserver {

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

    fun getUsers() {
        var disposible = repository.getUsers()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                it?.let { usersListResponse ->
                    usersListResponse.data.run {
                        homeLiveData.value = HomeState.UsersLoaded(this)
                    }
                }
            }
    }

    fun navigate() {
        homeLiveData.value = HomeState.Navigate
        homeLiveData.value = HomeState.Loading
    }

}