package nobdore.com.remote.test

import nobdore.com.remote.model.OwnerModel

/**
 * Created by AnkitSingh on 7/11/20.
 */
object OwnerFactory {
    fun makeOwnerModel(): OwnerModel {
        return OwnerModel(DataFactory.randomUuid(), DataFactory.randomUuid())
    }
}