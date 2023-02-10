package com.nexus.dictionary2.di

import com.nexus.dictionary2.dictionaryfeature.data.remote.DictionaryAPI
import com.nexus.dictionary2.dictionaryfeature.data.remote.DictionaryAPI.Companion.BASE_URL
import com.nexus.dictionary2.dictionaryfeature.data.repository.EntryRepositoryImpl
import com.nexus.dictionary2.dictionaryfeature.domain.repository.EntryRepository
import com.nexus.dictionary2.dictionaryfeature.domain.usecases.GetEntryInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDictionaryAPI(): DictionaryAPI {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(DictionaryAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideGetEntryInfoUseCase(repository: EntryRepository): GetEntryInfoUseCase {
        return GetEntryInfoUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideEntryRepository(
        api: DictionaryAPI
    ): EntryRepository {
        return EntryRepositoryImpl(api)
    }

}