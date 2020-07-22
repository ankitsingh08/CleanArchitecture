package nobdore.com.remote.mapper

import nobdore.com.data.model.ProjectEntity
import nobdore.com.remote.model.ProjectModel
import javax.inject.Inject

/**
 * Created by AnkitSingh on 7/11/20.
 */
class ProjectsResponseModelMapper @Inject constructor(): ModelMapper<ProjectModel, ProjectEntity> {
    override fun mapFromModel(model: ProjectModel): ProjectEntity {
        return ProjectEntity(model.id, model.name, model.fullName, model.starCount.toString(),
            model.dateCreated, model.owner.ownerName, model.owner.ownerAvatar)
    }

}