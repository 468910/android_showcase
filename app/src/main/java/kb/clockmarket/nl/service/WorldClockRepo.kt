package kb.clockmarket.nl.service

import io.reactivex.Observable
import kb.clockmarket.nl.api.RetrofitInstance
import kb.clockmarket.nl.api.WorldClockService
import kb.clockmarket.nl.model.WorldClockTimeStamp

class WorldClockRepo {

    var service  = RetrofitInstance.retrofit.create(WorldClockService::class.java)

    fun getTimeStampUtc() : Observable<WorldClockTimeStamp> = service.getTimeStampUtc()

}