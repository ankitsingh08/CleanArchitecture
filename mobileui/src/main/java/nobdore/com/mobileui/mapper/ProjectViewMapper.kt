package nobdore.com.mobileui.mapper

import nobdore.com.mobileui.model.Project
import nobdore.com.presentation.model.ProjectView
import javax.inject.Inject

/**
 * Created by AnkitSingh on 7/12/20.
 */
class ProjectViewMapper @Inject constructor(): ViewMapper<ProjectView, Project> {

    override fun mapToView(presentation: ProjectView): Project {
        return Project(presentation.id, presentation.name,
            presentation.fullName, presentation.starCount,
            presentation.dateCreated, presentation.ownerName,
            presentation.ownerAvatar, presentation.isBookmarked)
    }

}