package jp.co.yumemi.android.codeCheck.data.repository

import jp.co.yumemi.android.codeCheck.domain.Stargazer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class GitHubApiStargazersRepositoryImpl @Inject constructor() : GitHubApiStargazersRepository {

    private val mutableItemState = MutableStateFlow<List<Stargazer>>(emptyList())

    override fun observe(): StateFlow<List<Stargazer>> {
        return mutableItemState.asStateFlow()
    }

    override suspend fun update(list: List<Stargazer>) {
        mutableItemState.emit(list)
    }
}
