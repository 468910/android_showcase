package kb.clockmarket.nl.extensions

class Resource<T>(
    val status: Status,
    val data: T? = null,
    val message: String? = null
) {
    companion object {

        fun <T> success(data: T): Resource<T> = Resource(Status.SUCCESS, data)

        fun <T> error(msg: String?): Resource<T> = Resource(Status.ERROR, message = msg)

        fun <T> loading(): Resource<T> = Resource(Status.LOADING)
    }
}

enum class Status {
    SUCCESS, ERROR, LOADING
}