package com.trawlbens.reift.e_commerce.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trawlbens.reift.core.domain.model.Product
import com.trawlbens.reift.core.domain.usecase.product.ProductUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class HomeViewModel(
    val productUseCase: ProductUseCase,
) : ViewModel() {

    private val _listProductState: MutableStateFlow<List<Product>> = MutableStateFlow(listOf())
    val listProductState: StateFlow<List<Product>> = _listProductState

    fun getProductByCategory(category: String) {
        productUseCase.getProductByCategory(category).onEach { listProduct ->
            _listProductState.value = listProduct
        }.launchIn(viewModelScope)

    }

}