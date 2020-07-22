package nobdore.com.data.repository

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import nobdore.com.data.mapper.ProjectMapper
import nobdore.com.data.store.ProjectsDataStoreFactory
import nobdore.com.domain.model.Project
import nobdore.com.domain.repository.ProjectsRepository
import javax.inject.Inject

/**
 * Created by AnkitSingh on 7/11/20.
 */
class ProjectsDataRepository @Inject constructor(
    private val mapper: ProjectMapper,
    private val cache: ProjectsCache,
    private val factory: ProjectsDataStoreFactory
)
    : ProjectsRepository {

    override fun getProjects(): Observable<List<Project>> {
        return Observable.zip(cache.areProjectsCached().toObservable(),
            cache.isProjectsCacheExpired().toObservable(),
            BiFunction<Boolean, Boolean, Pair<Boolean, Boolean>> { areCached, isExpired ->
                Pair(areCached, isExpired)
            })
            .flatMap {
                factory.getDataStore(it.first, it.second).getProjects()
            }
            .flatMap { projects ->
                factory.getCacheDataStore()
                    .saveProjects(projects)
                    .andThen(Observable.just(projects))
            }
            .map { projectEntity ->
                projectEntity.map {
                    mapper.mapFromEntity(it)
                }
            }
    }

    override fun bookmarkProject(projectId: String): Completable {
        return factory.getCacheDataStore().setProjectAsBookmarked(projectId)
    }

    override fun unbookmarkProject(projectId: String): Completable {
        return factory.getCacheDataStore().setProjectAsNotBookmarked(projectId)
    }

    override fun getBookmarkedProjects(): Observable<List<Project>> {
        return factory.getCacheDataStore().getBookmarkedProjects()
            .map { projectEntity ->
                projectEntity.map { mapper.mapFromEntity(it) }
            }
    }


}