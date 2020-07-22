package nobdore.com.mobileui.mapper

/**
 * Created by AnkitSingh on 7/12/20.
 */
interface ViewMapper<in P, out V> {

    fun mapToView(presentation: P): V

}