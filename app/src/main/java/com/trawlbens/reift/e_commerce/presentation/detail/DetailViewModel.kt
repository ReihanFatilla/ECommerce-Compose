package com.trawlbens.reift.e_commerce.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trawlbens.reift.core.domain.model.Product
import com.trawlbens.reift.core.domain.usecase.detail.DetailUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class DetailViewModel(
    val detailUseCase: DetailUseCase
): ViewModel() {

    private val _isProductOnCartState: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isProductOnCartState: StateFlow<Boolean> = _isProductOnCartState

    fun addToCartProduct(product: Product){
        detailUseCase.addToCartProduct(product)
    }
    fun removeFromCartProduct(product: Product){
        detailUseCase.removeFromCartProduct(product)
    }
    fun isProductOnCart(id: Int){
        detailUseCase.isProductOnCart(id).onEach { isProductOnCart ->
            _isProductOnCartState.value = isProductOnCart
        }.launchIn(viewModelScope)
    }
}