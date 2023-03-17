package jp.co.yumemi.android.codeCheck.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber

@Module
@InstallIn(SingletonComponent::class)
class ProvideModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val logging = HttpLoggingInterceptor {
            Timber.tag("OkHttp").d(it)
        }.apply {
            setLevel(HttpLoggingInterceptor.Level.BASIC)
        }

        val client = OkHttpClient.Builder().addInterceptor(logging).build()
        val moshi = Moshi.Builder().build()

        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }
}