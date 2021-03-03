package com.keanequibilan.puppapp.ui.page.puppylist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keanequibilan.puppapp.network.DogService
import kotlinx.coroutines.launch

class PuppyListViewModel(
    private val api: DogService
) : ViewModel() {
    private val mutableItems = MutableLiveData(emptyList<String>())
    val items: LiveData<List<String>> = mutableItems

    init {
        viewModelScope.launch {
            api
                .randomDogs(25)
                .message
                .let { mutableItems.postValue(it) }
        }
    }
}
