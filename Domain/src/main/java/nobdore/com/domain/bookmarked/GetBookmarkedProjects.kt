package nobdore.com.domain.bookmarked

import io.reactivex.Observable
import nobdore.com.domain.executor.PostExecutionThread
import nobdore.com.domain.interactor.ObservableUseCase
import nobdore.com.domain.model.Project
import nobdore.com.domain.repository.ProjectsRepository
import javax.inject.Inject

/**
 * Created by AnkitSingh on 7/11/20.
 */
open class GetBookmarkedProjects @Inject constructor(
    private val projectsRepository: ProjectsRepository,
    postExecutionThread: PostExecutionThread
)
    : ObservableUseCase<List<Project>, Nothing?>(postExecutionThread) {

    public override fun buildUseCaseObservable(params: Nothing?): Observable<List<Project>> {
        return projectsRepository.getBookmarkedProjects()
    }
}