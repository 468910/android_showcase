package kb.clockmarket.nl.service

import android.arch.lifecycle.LiveData
import kb.clockmarket.nl.api.RetrofitInstance
import kb.clockmarket.nl.api.WorldClockService
import kb.clockmarket.nl.extensions.Resource
import kb.clockmarket.nl.extensions.toLiveDataWithResource
import kb.clockmarket.nl.model.WorldClockTimeStamp

class WorldClockRepo {

    var service  = RetrofitInstance.retrofit.create(WorldClockService::class.java)

    fun getTimeStampUtc() : LiveData<Resource<WorldClockTimeStamp>> = service.getTimeStampUtc().toLiveDataWithResource()

}