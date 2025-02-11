package nobdore.com.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable
import nobdore.com.cache.db.ProjectConstants.DELETE_PROJECTS
import nobdore.com.cache.db.ProjectConstants.QUERY_BOOKMARKED_PROJECTS
import nobdore.com.cache.db.ProjectConstants.QUERY_PROJECTS
import nobdore.com.cache.db.ProjectConstants.QUERY_UPDATE_BOOKMARK_STATUS
import nobdore.com.cache.model.CachedProject

/**
 * Created by AnkitSingh on 7/12/20.
 */
@Dao
abstract class CachedProjectsDao {

    @Query(QUERY_PROJECTS)
    @JvmSuppressWildcards
    abstract fun getProjects(): Flowable<List<CachedProject>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract fun insertProjects(projects: List<CachedProject>)

    @Query(DELETE_PROJECTS)
    abstract fun deleteProjects()

    @Query(QUERY_BOOKMARKED_PROJECTS)
    abstract fun getBookmarkedProjects(): Flowable<List<CachedProject>>

    @Query(QUERY_UPDATE_BOOKMARK_STATUS)
    abstract fun setBookmarkStatus(isBookmarked: Boolean,
                                   projectId: String)

}