package com.keanequibilan.puppapp.ui.page.animelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keanequibilan.puppapp.network.JikanService
import com.keanequibilan.puppapp.ui.model.Anime
import com.keanequibilan.puppapp.ui.theme.ErrorRed
import com.keanequibilan.puppapp.ui.theme.MovieBlue
import com.keanequibilan.puppapp.ui.theme.ONAGreen
import com.keanequibilan.puppapp.ui.theme.OVAGreen
import com.keanequibilan.puppapp.ui.theme.TVGreen
import com.keanequibilan.puppapp.ui.theme.UnknownBlack
import kotlinx.coroutines.launch

class AnimeListViewModel(
    private val api: JikanService
) : ViewModel() {
    private val mutableItems = MutableLiveData(emptyList<Anime>())
    val items: LiveData<List<Anime>> = mutableItems

    init {
        viewModelScope.launch {
            api
                .getTopUpcoming(1)
                .top
                .map {
                    with(it) {
                        Anime(
                            colour = when (type) {
                                "Movie" -> MovieBlue
                                "ONA" -> ONAGreen
                                "OVA" -> OVAGreen
                                "TV" -> TVGreen
                                "Unknown" -> UnknownBlack
                                else -> ErrorRed
                            },
                            id = mal_id,
                            image = image_url,
                            title = title
                        )
                    }
                }
                .let { mutableItems.postValue(it) }
        }
    }
}
