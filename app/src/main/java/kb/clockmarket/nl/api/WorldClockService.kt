package kb.clockmarket.nl.api

import io.reactivex.Observable
import io.reactivex.Single
import kb.clockmarket.nl.model.WorldClockTimeStamp
import retrofit2.http.GET


interface WorldClockService {

    @GET("api/json/utc/now")
    fun getTimeStampUtc(): Observable<WorldClockTimeStamp>

}