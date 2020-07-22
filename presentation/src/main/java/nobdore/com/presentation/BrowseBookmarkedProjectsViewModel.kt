package nobdore.com.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.observers.DisposableObserver
import nobdore.com.domain.bookmarked.GetBookmarkedProjects
import nobdore.com.domain.model.Project
import nobdore.com.presentation.mapper.ProjectViewMapper
import nobdore.com.presentation.model.ProjectView
import nobdore.com.presentation.state.Resource
import nobdore.com.presentation.state.ResourceState
import javax.inject.Inject

/**
 * Created by AnkitSingh on 7/12/20.
 */
class BrowseBookmarkedProjectsViewModel @Inject
constructor(
    private val getBookmarkedProjects: GetBookmarkedProjects,
    private val mapper: ProjectViewMapper
): ViewModel() {

    private val liveData: MutableLiveData<Resource<List<ProjectView>>> =
        MutableLiveData()

    override fun onCleared() {
        getBookmarkedProjects.dispose()
        super.onCleared()
    }

    fun getProjects(): LiveData<Resource<List<ProjectView>>> {
        return liveData
    }

    fun fetchProjects() {
        liveData.postValue(Resource(ResourceState.LOADING, null, null))
        return getBookmarkedProjects.execute(ProjectsSubscriber())
    }

    inner class ProjectsSubscriber: DisposableObserver<List<Project>>() {
        override fun onNext(t: List<Project>) {
            liveData.postValue(Resource(ResourceState.SUCCESS,
                t.map { mapper.mapToView(it) }, null))
        }

        override fun onError(e: Throwable) {
            liveData.postValue(Resource(ResourceState.ERROR, null,
                e.localizedMessage))
        }

        override fun onComplete() { }

    }

}