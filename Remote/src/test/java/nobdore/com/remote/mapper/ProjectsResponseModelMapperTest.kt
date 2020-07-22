package nobdore.com.remote.mapper

import nobdore.com.remote.test.ProjectFactory
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

/**
 * Created by AnkitSingh on 7/11/20.
 */
@RunWith(JUnit4::class)
open class ProjectsResponseModelMapperTest {

    private val mapper = ProjectsResponseModelMapper()

    @Test
    fun mapFromModelMapsData() {
        val model = ProjectFactory.makeProjectModel()
        val entity = mapper.mapFromModel(model)

        assertEquals(model.name, entity.name)
        assertEquals(model.fullName, entity.fullName)
        assertEquals(model.id, entity.id)
        assertEquals(model.starCount.toString(), entity.starCount)
        assertEquals(model.dateCreated, entity.dateCreated)
        assertEquals(model.owner.ownerName, entity.ownerName)
        assertEquals(model.owner.ownerAvatar, entity.ownerAvatar)
    }

}