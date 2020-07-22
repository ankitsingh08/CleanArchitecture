package nobdore.com.remote

import io.reactivex.Flowable
import io.reactivex.Observable
import nobdore.com.data.model.ProjectEntity
import nobdore.com.data.repository.ProjectsRemote
import nobdore.com.remote.mapper.ProjectsResponseModelMapper
import nobdore.com.remote.service.GithubTrendingService
import javax.inject.Inject

/**
 * Created by AnkitSingh on 7/11/20.
 */
class ProjectsRemoteImpl @Inject constructor(
    private val service: GithubTrendingService,
    private val mapper: ProjectsResponseModelMapper
)
    : ProjectsRemote {

    override fun getProjects(): Observable<List<ProjectEntity>> {
        return service.searchRepositories("language:kotlin", "stars", "desc")
            .map {
                it.items.map { mapper.mapFromModel(it) }
            }
    }
}