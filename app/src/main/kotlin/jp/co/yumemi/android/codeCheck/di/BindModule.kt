package jp.co.yumemi.android.codeCheck.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import jp.co.yumemi.android.codeCheck.data.api.GitHubApi
import jp.co.yumemi.android.codeCheck.data.api.GitHubApiClient
import jp.co.yumemi.android.codeCheck.data.apiservice.GitHubApiService
import jp.co.yumemi.android.codeCheck.data.apiservice.GitHubApiServiceImpl
import jp.co.yumemi.android.codeCheck.data.repository.GitHubApiRepository
import jp.co.yumemi.android.codeCheck.data.repository.GitHubApiRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface BindModule {

    @Binds
    @Singleton
    fun bindsGitHubApiClient(client: GitHubApiClient): GitHubApi

    @Binds
    @Singleton
    fun bindsGitHubApiService(impl: GitHubApiServiceImpl): GitHubApiService

    @Binds
    @Singleton
    fun bindsGitHubApiRepository(impl: GitHubApiRepositoryImpl): GitHubApiRepository
}