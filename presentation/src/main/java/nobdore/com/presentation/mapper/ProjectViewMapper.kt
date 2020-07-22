package nobdore.com.presentation.mapper

import nobdore.com.domain.model.Project
import nobdore.com.presentation.model.ProjectView
import javax.inject.Inject

/**
 * Created by AnkitSingh on 7/12/20.
 */
open class ProjectViewMapper @Inject constructor() : Mapper<ProjectView, Project> {

    override fun mapToView(type: Project): ProjectView {
        return ProjectView(type.id, type.name, type.fullName,
            type.starCount, type.dateCreated, type.ownerName,
            type.ownerAvatar, type.isBookmarked)
    }
}