package nobdore.com.data.repository

import io.reactivex.Observable
import nobdore.com.data.model.ProjectEntity

/**
 * Created by AnkitSingh on 7/11/20.
 */
interface ProjectsRemote {

    fun getProjects(): Observable<List<ProjectEntity>>

}