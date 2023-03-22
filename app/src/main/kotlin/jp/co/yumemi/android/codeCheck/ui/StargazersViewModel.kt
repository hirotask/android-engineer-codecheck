package jp.co.yumemi.android.codeCheck.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import jp.co.yumemi.android.codeCheck.data.apiservice.GitHubApiService
import jp.co.yumemi.android.codeCheck.data.repository.GitHubApiStargazersRepository
import jp.co.yumemi.android.codeCheck.domain.Stargazer
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class StargazersViewModel @Inject constructor(
    private val gitHubApiStargazersRepository: GitHubApiStargazersRepository,
    private val gitHubApiService: GitHubApiService
): ViewModel() {

    // Stargazersのリスト
    val itemState: StateFlow<List<Stargazer>> = gitHubApiStargazersRepository.observe()

    /**
     * githubのapiに問い合わせ、Stargazers一覧を取得する
     */
    fun searchResults(userName: String, repoName: String) {
        viewModelScope.launch {
            val list: List<Stargazer> = gitHubApiService.getStargazers(userName, repoName)
            gitHubApiStargazersRepository.update(list)
        }
    }

}