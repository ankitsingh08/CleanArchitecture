package nobdore.com.remote.mapper

/**
 * Created by AnkitSingh on 7/11/20.
 */
interface ModelMapper<in M, out E> {

    fun mapFromModel(model: M): E

}