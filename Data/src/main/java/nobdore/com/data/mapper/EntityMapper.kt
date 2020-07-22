package nobdore.com.data.mapper

/**
 * Created by AnkitSingh on 7/11/20.
 */
interface EntityMapper<E, D> {

    fun mapFromEntity(entity: E): D

    fun mapToEntity(domain: D): E

}