package com.example.android.common.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.example.android.common.utils.Event
import com.example.android.navigation.NavigationCommand
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    protected var disposables = CompositeDisposable()

    protected val _snackbarError = MutableLiveData<Event<String>>()
    val snackBarError: LiveData<Event<String>> get() = _snackbarError

    protected val _loaderProgressBar = MutableLiveData<Event<Boolean>>()
    val loaderProgressBar: LiveData<Event<Boolean>> get() = _loaderProgressBar

    private val _navigation = MutableLiveData<Event<NavigationCommand>>()
    val navigation: LiveData<Event<NavigationCommand>> = _navigation

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    fun navigate(directions: NavDirections) {
        _navigation.value = Event(NavigationCommand.To(directions))
    }
}