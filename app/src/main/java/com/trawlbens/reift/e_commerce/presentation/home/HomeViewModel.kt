package com.trawlbens.reift.e_commerce.presentation.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.trawlbens.reift.core.domain.model.Product
import com.trawlbens.reift.core.domain.usecase.product.ProductUseCase
import kotlinx.coroutines.flow.onEach

class HomeViewModel(
    val productUseCase: ProductUseCase
): ViewModel() {

    private val _listProductState: MutableState<List<Product>> = mutableStateOf(listOf())
    val listProductState: State<List<Product>> = _listProductState

    fun getProductByCategory(category: String) {
        productUseCase.getProductByCategory(category).onEach { listProduct ->
            _listProductState.value = listProduct
        }
    }

}