package nobdore.com.presentation.state

/**
 * Created by AnkitSingh on 7/12/20.
 */
class Resource<out T> constructor(val status: ResourceState,
                                  val data: T?,
                                  val message: String?) {

    fun <T> success(data: T): Resource<T> {
        return Resource(ResourceState.SUCCESS, data, null)
    }

    fun <T> error(message: String?): Resource<T> {
        return Resource(ResourceState.ERROR, null, message)
    }

    fun <T> loading(): Resource<T> {
        return Resource(ResourceState.LOADING, null, null)
    }

}