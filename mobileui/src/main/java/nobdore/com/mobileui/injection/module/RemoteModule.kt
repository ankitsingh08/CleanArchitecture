package nobdore.com.mobileui.injection.module

import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.android.BuildConfig
import nobdore.com.data.repository.ProjectsRemote
import nobdore.com.remote.ProjectsRemoteImpl
import nobdore.com.remote.service.GithubTrendingService
import nobdore.com.remote.service.GithubTrendingServiceFactory

/**
 * Created by AnkitSingh on 7/12/20.
 */
@Module
abstract class RemoteModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideGithubService(): GithubTrendingService {
            return GithubTrendingServiceFactory().makeGithubTrendingService(BuildConfig.DEBUG)
        }
    }

    @Binds
    abstract fun bindProjectsRemote(projectsRemote: ProjectsRemoteImpl): ProjectsRemote
}