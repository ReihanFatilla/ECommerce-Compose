package com.trawlbens.reift.e_commerce.presentation.cart

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trawlbens.reift.core.domain.model.Product
import com.trawlbens.reift.core.domain.usecase.cart.CartUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class CartViewModel(
    val cartUseCase: CartUseCase
): ViewModel() {
    private val _listCartProductState: MutableStateFlow<List<Product>> = MutableStateFlow(listOf())
    val listCartProductState: StateFlow<List<Product>> = _listCartProductState

    fun getProductByCategory(category: String) {
        cartUseCase.getCartProduct().onEach { listProduct ->
            _listCartProductState.value = listProduct
        }.launchIn(viewModelScope)
    }
}