package nobdore.com.cache.mapper

/**
 * Created by AnkitSingh on 7/12/20.
 */
interface CacheMapper<C, E> {

    fun mapFromCached(type: C): E

    fun mapToCached(type: E): C

}