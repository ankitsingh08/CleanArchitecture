package nobdore.com.data.store

import io.reactivex.Completable
import io.reactivex.Observable
import nobdore.com.data.model.ProjectEntity
import nobdore.com.data.repository.ProjectsCache
import nobdore.com.data.repository.ProjectsDataStore
import javax.inject.Inject

/**
 * Created by AnkitSingh on 7/11/20.
 */
open class ProjectsCacheDataStore @Inject constructor(
    private val projectsCache: ProjectsCache
)
    : ProjectsDataStore {

    override fun getProjects(): Observable<List<ProjectEntity>> {
        return projectsCache.getProjects()
    }

    override fun saveProjects(projects: List<ProjectEntity>): Completable {
        return projectsCache.saveProjects(projects)
            .andThen(projectsCache.setLastCacheTime(System.currentTimeMillis()))
    }

    override fun clearProjects(): Completable {
        return projectsCache.clearProjects()
    }

    override fun getBookmarkedProjects(): Observable<List<ProjectEntity>> {
        return projectsCache.getBookmarkedProjects()
    }

    override fun setProjectAsBookmarked(projectId: String): Completable {
        return projectsCache.setProjectAsBookmarked(projectId)
    }

    override fun setProjectAsNotBookmarked(projectId: String): Completable {
        return projectsCache.setProjectAsNotBookmarked(projectId)
    }

}