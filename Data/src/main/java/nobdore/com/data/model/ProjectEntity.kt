package nobdore.com.data.model

/**
 * Created by AnkitSingh on 7/11/20.
 */
class ProjectEntity(val id: String, val name: String, val fullName: String,
                    val starCount: String, val dateCreated: String,
                    val ownerName: String, val ownerAvatar: String,
                    val isBookmarked: Boolean = false)