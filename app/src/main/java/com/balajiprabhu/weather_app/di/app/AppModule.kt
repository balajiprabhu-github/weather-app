package com.balajiprabhu.weather_app.di.app

import com.balajiprabhu.weather_app.repository.network.AppService
import com.balajiprabhu.weather_app.repository.network.Constants
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class AppModule {

    companion object{

        @Singleton
        @Provides
        fun providesInterceptor(): Interceptor {
            return object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response {
                    var request = chain.request()
                    request = request.newBuilder()
                        .addHeader("X-RapidAPI-Key","4fc318d903mshf57c0a4b90734bep15668djsn0fa8ed47953a")
                        .build()
                    return chain.proceed(request)
                }
            }
        }

        @Singleton
        @Provides
        fun providesOkHttpClient(interceptor: Interceptor): OkHttpClient {
            return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()
        }

        @Singleton
        @Provides
        fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

        @Singleton
        @Provides
        fun providesAppClient(retrofit: Retrofit) : AppService =
            retrofit.create(AppService::class.java)

    }
}