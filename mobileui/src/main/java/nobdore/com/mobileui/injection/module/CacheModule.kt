package nobdore.com.mobileui.injection.module

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.Provides
import nobdore.com.cache.ProjectsCacheImpl
import nobdore.com.cache.db.ProjectsDatabase
import nobdore.com.data.repository.ProjectsCache

/**
 * Created by AnkitSingh on 7/12/20.
 */
@Module
abstract class CacheModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun providesDataBase(application: Application): ProjectsDatabase {
            return ProjectsDatabase.getInstance(application)
        }
    }

    @Binds
    abstract fun bindProjectsCache(projectsCache: ProjectsCacheImpl): ProjectsCache
}