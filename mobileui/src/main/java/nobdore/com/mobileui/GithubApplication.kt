package nobdore.com.mobileui

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import nobdore.com.mobileui.injection.DaggerApplicationComponent
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by AnkitSingh on 7/12/20.
 */
class GithubApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return androidInjector
    }

    override fun onCreate() {
        super.onCreate()
        setupTimber()

        DaggerApplicationComponent
            .builder()
            .application(this)
            .build()
            .inject(this)
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }
}