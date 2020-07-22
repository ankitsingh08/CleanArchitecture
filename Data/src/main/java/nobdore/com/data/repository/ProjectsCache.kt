package nobdore.com.data.repository

import io.reactivex.Completable

import io.reactivex.Observable
import io.reactivex.Single
import nobdore.com.data.model.ProjectEntity
import java.util.*

/**
 * Created by AnkitSingh on 7/11/20.
 */
interface ProjectsCache  {

    fun clearProjects(): Completable

    fun saveProjects(projects: List<ProjectEntity>): Completable

    fun getProjects(): io.reactivex.Observable<List<ProjectEntity>>

    fun getBookmarkedProjects(): Observable<List<ProjectEntity>>

    fun setProjectAsBookmarked(projectId: String): Completable

    fun setProjectAsNotBookmarked(projectId: String): Completable

    fun areProjectsCached(): Single<Boolean>

    fun setLastCacheTime(lastCache: Long): Completable

    fun isProjectsCacheExpired(): Single<Boolean>

}