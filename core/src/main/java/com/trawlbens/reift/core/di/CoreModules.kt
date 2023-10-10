package com.trawlbens.reift.core.di

import android.util.Log
import androidx.room.Room
import com.trawlbens.reift.core.data.repository.cart.CartRepositoryImpl
import com.trawlbens.reift.core.data.repository.detail.DetailRepositoryImpl
import com.trawlbens.reift.core.data.repository.product.ProductRepositoryImpl
import com.trawlbens.reift.core.data.repository.search.SearchRepositoryImpl
import com.trawlbens.reift.core.data.source.local.LocalDataSource
import com.trawlbens.reift.core.data.source.local.room.database.ProductDataBase
import com.trawlbens.reift.core.data.source.remote.RemoteDataSource
import com.trawlbens.reift.core.data.source.remote.api.ProductApi
import com.trawlbens.reift.core.data.source.remote.api.ProductApiImpl
import com.trawlbens.reift.core.domain.repository.cart.CartRepository
import com.trawlbens.reift.core.domain.repository.detail.DetailRepository
import com.trawlbens.reift.core.domain.repository.product.ProductRepository
import com.trawlbens.reift.core.domain.repository.search.SearchRepository
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.HttpTimeout
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import kotlinx.serialization.json.Json
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val networkModule = module {
    single {
        HttpClient(Android){
            install(HttpTimeout) {
                requestTimeoutMillis = 15000L
                connectTimeoutMillis = 15000L
                socketTimeoutMillis = 15000L
            }

            install(JsonFeature) {
                serializer = KotlinxSerializer(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }

            install(Logging) {

                level = LogLevel.ALL
                logger = object : Logger {
                    override fun log(message: String) {
                        Log.i("KTOR_LOGGER", message)
                    }

                }
            }
        }
    }
    single<ProductApi> {
        ProductApiImpl(get())
    }
}

val databaseModule = module {
    factory { get<ProductDataBase>().productDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            ProductDataBase::class.java, "product.database"
        ).fallbackToDestructiveMigration()
            .build()
    }
}

val dataSourceModule = module {
    factory { RemoteDataSource(get()) }
    factory { LocalDataSource(get()) }
}

val repositoryModule = module {
    single<ProductRepository> { ProductRepositoryImpl(get()) }
    single<DetailRepository> { DetailRepositoryImpl(get()) }
    single<CartRepository> { CartRepositoryImpl(get()) }
    single<SearchRepository> { SearchRepositoryImpl(get()) }
}