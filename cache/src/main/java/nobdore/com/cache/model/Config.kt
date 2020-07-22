package nobdore.com.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import nobdore.com.cache.db.ConfigConstants

/**
 * Created by AnkitSingh on 7/12/20.
 */
@Entity(tableName = ConfigConstants.TABLE_NAME)
data class Config(
    @PrimaryKey(autoGenerate = true)
    var id: Int = -1,
    var lastCacheTime: Long)