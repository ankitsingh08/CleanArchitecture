package nobdore.com.domain.bookmark

import com.nhaarman.mockito_kotlin.whenever
import nobdore.com.domain.bookmarked.GetBookmarkedProjects
import nobdore.com.domain.executor.PostExecutionThread
import nobdore.com.domain.model.Project
import nobdore.com.domain.repository.ProjectsRepository
import nobdore.com.domain.test.ProjectDataFactory
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 * Created by AnkitSingh on 7/11/20.
 */
class GetBookmarkedProjectTest {

    private lateinit var getBookmarkedProjects: GetBookmarkedProjects
    @Mock
    lateinit var projectsRepository: ProjectsRepository
    @Mock lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        getBookmarkedProjects = GetBookmarkedProjects(projectsRepository, postExecutionThread)
    }

    @Test
    fun getBookmarkedProjectsCompletes() {
        stubGetProjects(Observable.just(ProjectDataFactory.makeProjectList(2)))
        val testObserver = getBookmarkedProjects.buildUseCaseObservable().test()
        testObserver.assertComplete()
    }

    @Test
    fun getBookmarkedProjectsReturnsData() {
        val projects = ProjectDataFactory.makeProjectList(2)
        stubGetProjects(Observable.just(projects))
        val testObserver = getBookmarkedProjects.buildUseCaseObservable().test()
        testObserver.assertValue(projects)
    }

    private fun stubGetProjects(observable: Observable<List<Project>>) {
        whenever(projectsRepository.getBookmarkedProjects())
            .thenReturn(observable)
    }


}