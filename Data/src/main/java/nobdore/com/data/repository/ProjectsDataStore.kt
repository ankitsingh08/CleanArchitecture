package nobdore.com.data.repository

import io.reactivex.Completable
import io.reactivex.Observable
import nobdore.com.data.model.ProjectEntity

/**
 * Created by AnkitSingh on 7/11/20.
 */
interface ProjectsDataStore {

    fun getProjects(): Observable<List<ProjectEntity>>

    fun saveProjects(projects: List<ProjectEntity>): Completable

    fun clearProjects(): Completable

    fun getBookmarkedProjects(): Observable<List<ProjectEntity>>

    fun setProjectAsBookmarked(projectId: String): Completable

    fun setProjectAsNotBookmarked(projectId: String): Completable

}