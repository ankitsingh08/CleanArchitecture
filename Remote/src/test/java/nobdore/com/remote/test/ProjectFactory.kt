package nobdore.com.remote.test

import nobdore.com.remote.model.ProjectModel

/**
 * Created by AnkitSingh on 7/11/20.
 */
object ProjectFactory {
    fun makeProjectModel(): ProjectModel {
        return ProjectModel(DataFactory.randomUuid(),
            DataFactory.randomUuid(), DataFactory.randomUuid(),
            DataFactory.randomInt(), DataFactory.randomUuid(),
            OwnerFactory.makeOwnerModel())
    }
}