package jp.co.yumemi.android.codeCheck

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import jp.co.yumemi.android.codeCheck.data.api.GitHubApiClient
import jp.co.yumemi.android.codeCheck.domain.ItemJson
import jp.co.yumemi.android.codeCheck.domain.ItemJsonResponse
import jp.co.yumemi.android.codeCheck.domain.Owner
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GitHubApiClientTest {

    /**
     * GitHubRepositoryを検索語"AAA"で検索できるかテスト
     */
    @Test
    fun get_GitHubRepository_WhenAAA() {
        val testString = "AAA"
        val api = mockk<GitHubApiClient>()
        val itemResponse = ItemJsonResponse(
            listOf(
                ItemJson(
                    "test",
                    Owner("test"),
                    "test",
                    0,
                    0,
                    0,
                    0,
                    "test",
                    "test",
                    "test")
            )
        )

        coEvery { api.getGitHubItems(testString) } returns itemResponse

        runBlocking {
            api.getGitHubItems(testString)
        }

        coVerify { api.getGitHubItems(testString) }

        confirmVerified(api)
    }
}
