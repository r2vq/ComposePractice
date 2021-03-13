package com.keanequibilan.puppapp.repository

import androidx.paging.PagingSource
import com.keanequibilan.puppapp.repository.model.PokedexItem

internal abstract class PokedexSource : PagingSource<Int, PokedexItem>()
