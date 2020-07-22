package nobdore.com.cache.mapper

import nobdore.com.cache.model.CachedProject
import nobdore.com.data.model.ProjectEntity
import javax.inject.Inject

/**
 * Created by AnkitSingh on 7/12/20.
 */
class CachedProjectMapper @Inject constructor(): CacheMapper<CachedProject, ProjectEntity> {

    override fun mapFromCached(type: CachedProject): ProjectEntity {
        return ProjectEntity(type.id, type.name, type.fullName, type.starCount,
            type.dateCreated, type.ownerName, type.ownerAvatar,
            type.isBookmarked)
    }

    override fun mapToCached(type: ProjectEntity): CachedProject {
        return CachedProject(type.id, type.name, type.fullName, type.starCount,
            type.dateCreated, type.ownerName, type.ownerAvatar,
            type.isBookmarked)
    }

}