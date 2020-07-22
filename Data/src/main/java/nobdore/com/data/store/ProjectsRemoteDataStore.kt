package nobdore.com.data.store

import io.reactivex.Completable
import io.reactivex.Observable
import nobdore.com.data.model.ProjectEntity
import nobdore.com.data.repository.ProjectsDataStore
import nobdore.com.data.repository.ProjectsRemote
import javax.inject.Inject

/**
 * Created by AnkitSingh on 7/11/20.
 */
open class ProjectsRemoteDataStore @Inject constructor(
    private val projectsRemote: ProjectsRemote
)
    : ProjectsDataStore {

    override fun getProjects(): Observable<List<ProjectEntity>> {
        return projectsRemote.getProjects()
    }

    override fun saveProjects(projects: List<ProjectEntity>): Completable {
        throw UnsupportedOperationException("Saving projects isn't supported here...")
    }

    override fun clearProjects(): Completable {
        throw UnsupportedOperationException("Clearing projects isn't supported here...")
    }

    override fun getBookmarkedProjects(): Observable<List<ProjectEntity>> {
        throw UnsupportedOperationException("Getting bookmarked projects isn't supported here...")
    }

    override fun setProjectAsBookmarked(projectId: String): Completable {
        throw UnsupportedOperationException("Setting bookmarks isn't supported here...")
    }

    override fun setProjectAsNotBookmarked(projectId: String): Completable {
        throw UnsupportedOperationException("Setting bookmarks isn't supported here...")
    }

}