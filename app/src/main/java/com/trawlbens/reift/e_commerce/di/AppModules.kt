package com.trawlbens.reift.e_commerce.di

import android.util.Log
import com.trawlbens.reift.core.di.dataSourceModule
import com.trawlbens.reift.core.di.databaseModule
import com.trawlbens.reift.core.di.networkModule
import com.trawlbens.reift.core.di.repositoryModule
import com.trawlbens.reift.core.domain.usecase.cart.CartInteractor
import com.trawlbens.reift.core.domain.usecase.cart.CartUseCase
import com.trawlbens.reift.core.domain.usecase.detail.DetailInteractor
import com.trawlbens.reift.core.domain.usecase.detail.DetailUseCase
import com.trawlbens.reift.core.domain.usecase.product.ProductInteractor
import com.trawlbens.reift.core.domain.usecase.product.ProductUseCase
import com.trawlbens.reift.core.domain.usecase.search.SearchInteractor
import com.trawlbens.reift.core.domain.usecase.search.SearchUseCase
import com.trawlbens.reift.e_commerce.presentation.cart.CartViewModel
import com.trawlbens.reift.e_commerce.presentation.detail.DetailViewModel
import com.trawlbens.reift.e_commerce.presentation.home.HomeViewModel
import com.trawlbens.reift.e_commerce.presentation.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val useCaseModule = module {
    single<ProductUseCase> { ProductInteractor(get()) }
    single<DetailUseCase> { DetailInteractor(get()) }
    single<CartUseCase> { CartInteractor(get()) }
    single<SearchUseCase> { SearchInteractor(get()) }
}

val viewModelModule = module {
    factory { (useCase: ProductUseCase) -> HomeViewModel(useCase) }
    viewModel { DetailViewModel(get()) }
    viewModel { CartViewModel(get()) }
    viewModel { SearchViewModel(get()) }
}

val listModules = listOf(
    databaseModule,
    networkModule,
    dataSourceModule,
    repositoryModule,
    useCaseModule,
    viewModelModule
)