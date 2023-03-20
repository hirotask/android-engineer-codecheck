package jp.co.yumemi.android.codeCheck

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import jp.co.yumemi.android.codeCheck.ui.TopActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest
class TopActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(TopActivity::class.java)

    @Test
    fun test_isSearchFragmentVisible_onAppLaunch() {
        onView(withId(R.id.searchBar)).check(matches(isDisplayed()))
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isRepositoryDetailFragmentVisible() {
        onView(withId(R.id.ownerIconView)).check(matches(isDisplayed()))
        onView(withId(R.id.nameView)).check(matches(isDisplayed()))
        onView(withId(R.id.languageView)).check(matches(isDisplayed()))
        onView(withId(R.id.starsView)).check(matches(isDisplayed()))
        onView(withId(R.id.watchersView)).check(matches(isDisplayed()))
        onView(withId(R.id.forksView)).check(matches(isDisplayed()))
        onView(withId(R.id.openIssuesView)).check(matches(isDisplayed()))
    }
}