package com.example.democomposeapp.di
import com.example.democomposeapp.api.PhotoApi
import com.example.democomposeapp.utils.Const
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
             .baseUrl(Const.BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providePhotoAPI(retrofit: Retrofit): PhotoApi {
        return retrofit.create(PhotoApi::class.java)
    }


}