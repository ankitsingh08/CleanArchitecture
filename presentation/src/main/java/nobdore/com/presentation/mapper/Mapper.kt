package nobdore.com.presentation.mapper

/**
 * Created by AnkitSingh on 7/12/20.
 */
interface Mapper<out V, in D> {

    fun mapToView(type: D): V

}