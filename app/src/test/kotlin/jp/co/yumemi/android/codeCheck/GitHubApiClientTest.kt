package jp.co.yumemi.android.codeCheck

import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import jp.co.yumemi.android.codeCheck.data.api.GitHubApiClient
import jp.co.yumemi.android.codeCheck.domain.ItemJson
import jp.co.yumemi.android.codeCheck.domain.ItemJsonResponse
import jp.co.yumemi.android.codeCheck.domain.Owner
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GitHubApiClientTest {

    @Test
    fun get_GitHubRepository_WhenAAA() {
        val testString = "AAA"
        val api = mockk<GitHubApiClient>()
        val itemResponse = ItemJsonResponse(
            listOf(
                ItemJson("test", Owner("test"), "test", 0, 0, 0, 0)
            )
        )

        every {
            runBlocking {
                api.getGitHubItems(testString)
            }
        } returns itemResponse

        runBlocking {
            api.getGitHubItems(testString)
        }

        verify {
            runBlocking {
                api.getGitHubItems(testString)
            }
        }

        confirmVerified(api)
    }
}