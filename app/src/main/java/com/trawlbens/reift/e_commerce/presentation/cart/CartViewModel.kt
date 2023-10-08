package com.trawlbens.reift.e_commerce.presentation.cart

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.trawlbens.reift.core.domain.model.Product
import com.trawlbens.reift.core.domain.usecase.cart.CartUseCase
import kotlinx.coroutines.flow.onEach

class CartViewModel(
    val cartUseCase: CartUseCase
): ViewModel() {
    private val _listCartProductState: MutableState<List<Product>> = mutableStateOf(listOf())
    val listCartProductState: State<List<Product>> = _listCartProductState

    fun getProductByCategory(category: String) {
        cartUseCase.getCartProduct().onEach { listProduct ->
            _listCartProductState.value = listProduct
        }
    }
}