package nobdore.com.remote.service

import io.reactivex.Observable
import nobdore.com.remote.model.ProjectsResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by AnkitSingh on 7/11/20.
 */
interface GithubTrendingService {

    @GET("search/repositories")
    fun searchRepositories(@Query("q") query: String,
                           @Query("sort") sortBy: String,
                           @Query("order") order: String)
            : Observable<ProjectsResponseModel>

}