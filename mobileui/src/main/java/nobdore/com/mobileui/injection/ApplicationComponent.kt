package nobdore.com.mobileui.injection

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import nobdore.com.mobileui.GithubApplication
import nobdore.com.mobileui.injection.module.*
import javax.inject.Singleton

/**
 * Created by AnkitSingh on 7/12/20.
 */
@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class,
    ApplicationModule::class,
    UiModule::class,
    PresentationModule::class,
    DataModule::class,
    CacheModule::class,
    RemoteModule::class))
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: GithubApplication)

}