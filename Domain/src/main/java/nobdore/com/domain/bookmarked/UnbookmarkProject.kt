package nobdore.com.domain.bookmarked

import io.reactivex.Completable
import nobdore.com.domain.executor.PostExecutionThread
import nobdore.com.domain.interactor.CompletableUseCase
import nobdore.com.domain.repository.ProjectsRepository
import javax.inject.Inject

/**
 * Created by AnkitSingh on 7/11/20.
 */
class UnbookmarkProject @Inject constructor(
    private val projectsRepository: ProjectsRepository,
    postExecutionThread: PostExecutionThread
)
    : CompletableUseCase<UnbookmarkProject.Params>(postExecutionThread){

    public override fun buildUseCaseCompletable(params: Params?): Completable {
        if (params == null) throw IllegalArgumentException("Params can't be null!")
        return projectsRepository.unbookmarkProject(params.projectId)
    }

    data class Params constructor(val projectId: String) {
        companion object {
            fun forProject(projectId: String): Params {
                return Params(projectId)
            }
        }
    }

}