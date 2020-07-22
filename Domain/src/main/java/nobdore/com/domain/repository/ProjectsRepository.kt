package nobdore.com.domain.repository

import io.reactivex.Completable
import io.reactivex.Observable
import nobdore.com.domain.model.Project

/**
 * Created by AnkitSingh on 7/11/20.
 */
interface ProjectsRepository {
    fun getProjects(): Observable<List<Project>>

    fun bookmarkProject(projectId: String): Completable

    fun unbookmarkProject(projectId: String): Completable

    fun getBookmarkedProjects(): Observable<List<Project>>

}