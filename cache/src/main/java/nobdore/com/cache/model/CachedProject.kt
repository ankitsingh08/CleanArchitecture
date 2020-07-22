package nobdore.com.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import nobdore.com.cache.db.ProjectConstants

/**
 * Created by AnkitSingh on 7/12/20.
 */
@Entity(tableName = ProjectConstants.TABLE_NAME)
data class CachedProject(
    @PrimaryKey
    @ColumnInfo(name = ProjectConstants.COLUMN_PROJECT_ID)
    var id: String,
    var name: String,
    var fullName: String,
    var starCount: String,
    var dateCreated: String,
    var ownerName: String,
    var ownerAvatar: String,
    @ColumnInfo(name = ProjectConstants.COLUMN_IS_BOOKMARKED)
    var isBookmarked: Boolean
)