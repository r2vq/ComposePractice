package com.keanequibilan.puppapp.ui.puppylist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PuppyListViewModel : ViewModel() {
    private val mutableItems = MutableLiveData(emptyList<String>())
    val items: LiveData<List<String>> = mutableItems

    init {
        mutableItems.postValue(
            listOf(
                "https://images.dog.ceo/breeds/mountain-swiss/n02107574_2773.jpg",
                "https://images.dog.ceo/breeds/labrador/n02099712_3769.jpg",
                "https://images.dog.ceo/breeds/newfoundland/n02111277_6672.jpg",
            )
        )
    }
}
