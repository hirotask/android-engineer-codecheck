package jp.co.yumemi.android.codeCheck.data.repository

import jp.co.yumemi.android.codeCheck.domain.Item
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class GitHubApiItemRepositoryImpl @Inject constructor() : GitHubApiItemRepository {

    private val mutableItemState = MutableStateFlow<List<Item>>(emptyList())

    override fun observe(): StateFlow<List<Item>> {
        return mutableItemState.asStateFlow()
    }

    override suspend fun update(list: List<Item>) {
        mutableItemState.emit(list)
    }
}
