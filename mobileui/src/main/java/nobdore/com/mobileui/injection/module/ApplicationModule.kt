package nobdore.com.mobileui.injection.module

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

/**
 * Created by AnkitSingh on 7/12/20.
 */
@Module
abstract class ApplicationModule {

    @Binds
    abstract fun bindContext(application: Application): Context
}