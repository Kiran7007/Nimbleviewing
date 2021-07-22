package com.wwt.nimbleviewing.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.wwt.nimbleviewing.BuildConfig
import com.wwt.nimbleviewing.data.remote.ApiService
import com.wwt.nimbleviewing.data.repository.AlbumArtRepository
import com.wwt.nimbleviewing.data.repository.AlbumArtRepositoryImpl
import com.wwt.nimbleviewing.ui.home.AlbumArtViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val remoteModules = module {
    single {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }

    single(createdAtStart = false) { get<Retrofit>().create(ApiService::class.java) }
}

val repositoryModule = module{
    single<AlbumArtRepository> { AlbumArtRepositoryImpl(get()) }
}

val viewmodelModule = module {
    viewModel { AlbumArtViewModel(get()) }
}