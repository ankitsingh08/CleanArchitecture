package nobdore.com.mobileui.injection.module

import dagger.Binds
import dagger.Module
import nobdore.com.data.repository.ProjectsDataRepository
import nobdore.com.domain.repository.ProjectsRepository

/**
 * Created by AnkitSingh on 7/12/20.
 */
@Module
abstract class DataModule {

    @Binds
    abstract fun bindDataRepository(dataRepository: ProjectsDataRepository): ProjectsRepository
}