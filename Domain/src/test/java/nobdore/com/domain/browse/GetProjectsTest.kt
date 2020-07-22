package nobdore.com.domain.browse

import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import nobdore.com.domain.executor.PostExecutionThread
import nobdore.com.domain.model.Project
import nobdore.com.domain.repository.ProjectsRepository
import nobdore.com.domain.test.ProjectDataFactory
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 * Created by AnkitSingh on 7/11/20.
 */
class GetProjectsTest {

    private lateinit var getProjects: GetProjects
    @Mock lateinit var projectsRepository: ProjectsRepository
    @Mock lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        getProjects = GetProjects(
            projectsRepository,
            postExecutionThread
        )
    }

    @Test
    fun getProjectCompletes() {
       stubGetProjects(Observable.just(ProjectDataFactory.makeProjectList(2)))
        val testObserver = getProjects.buildUseCaseObservable().test()
        testObserver.assertComplete()
    }

    @Test
    fun getProjectReturnsData() {
        val projects = ProjectDataFactory.makeProjectList(2)
        stubGetProjects(Observable.just(projects))
        val testObserver = getProjects.buildUseCaseObservable().test()
        testObserver.assertComplete()
        testObserver.assertValue(projects)
    }

    private fun stubGetProjects(observable: Observable<List<Project>>) {
        whenever(projectsRepository.getProjects())
            .thenReturn(observable)
    }

}