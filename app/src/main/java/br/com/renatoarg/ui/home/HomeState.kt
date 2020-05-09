package br.com.renatoarg.ui.home

sealed class HomeState {

    object Init: HomeState()

    object Loading: HomeState()

    object FakeRequest: HomeState()

}