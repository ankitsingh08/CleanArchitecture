package nobdore.com.mobileui.injection.module

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import nobdore.com.domain.executor.PostExecutionThread
import nobdore.com.mobileui.UiThread
import nobdore.com.mobileui.view.bookmarked.BookmarkedActivity
import nobdore.com.mobileui.view.browse.BrowseActivity

/**
 * Created by AnkitSingh on 7/12/20.
 */
@Module
abstract class UiModule {

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UiThread): PostExecutionThread

    @ContributesAndroidInjector
    abstract fun contributesBrowseActivity(): BrowseActivity

    @ContributesAndroidInjector
    abstract fun contributesBookmarkedActivity(): BookmarkedActivity
}