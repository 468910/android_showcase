package kb.clockmarket.nl.extensions

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Publisher
import timber.log.Timber

/**
 * Transforms a RxPublisher to LiveData with the Android LiveDataReactiveStream API
 * Can be used as is instead of using toLiveDataWithResource however NOTE that you have to handle
 * Errors as state before transforming to LiveData
 */
fun <T> Publisher<T>.toLiveData() = LiveDataReactiveStreams.fromPublisher(this)

/**
 * Transform a RxPublisher to LiveData<Resource<T>>, handles Errors as state as
 * required by Android by LiveDataReactiveStream API.
 * By emitting an Resource holding an error message
 * Additionality runs the required LiveData on a thread
 * safe for API usage and will start with emitting a Resource.loading()
 */
fun <T> Observable<T>.toLiveDataWithResource(): LiveData<Resource<T>> {
    return this.switchMap { Observable.just(Resource.success(it)) }
        .startWith(Resource.loading())
        .onErrReturn { Resource.error(it.message) }
        .toFlowable(BackpressureStrategy.MISSING)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .toLiveData()
}

/**
 * Extension function wrapper around onError Return,
 * used for automatically logging to Tinder
 */
fun <T> Observable<T>.onErrReturn(e: (Throwable) -> T): Observable<T> {
    return this.onErrorReturn { error ->
        Timber.e(error, "Error %s", error.message)
        e(error)
    }
}