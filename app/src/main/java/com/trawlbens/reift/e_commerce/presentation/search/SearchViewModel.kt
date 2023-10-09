package com.trawlbens.reift.e_commerce.presentation.search

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.trawlbens.reift.core.domain.model.Product
import com.trawlbens.reift.core.domain.usecase.search.SearchUseCase
import kotlinx.coroutines.flow.onEach

class SearchViewModel(
    val searchUseCase: SearchUseCase
): ViewModel() {

    init {
        getAllProduct()
    }

    private val listProductState: MutableState<List<Product>> = mutableStateOf(listOf())

    private val _listSearchedProductState: MutableState<List<Product>> = mutableStateOf(listOf())
    val listSearchedProductState: State<List<Product>> = _listSearchedProductState

    private fun getAllProduct() {
        searchUseCase.getAllProducts().onEach { listProduct ->
            listProductState.value = listProduct
        }
    }

    fun searchProduct(query: String) {
        _listSearchedProductState.value = listProductState.value.filter {
            it.name.contains(query) || it.description.contains(query)
        }
    }

}