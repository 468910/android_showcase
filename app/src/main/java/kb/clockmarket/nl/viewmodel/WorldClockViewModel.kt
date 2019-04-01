package kb.clockmarket.nl.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import kb.clockmarket.nl.extensions.Resource
import kb.clockmarket.nl.extensions.toLiveDataWithResource
import kb.clockmarket.nl.model.WorldClockTimeStamp
import kb.clockmarket.nl.service.WorldClockRepo

class WorldClockViewModel(val repo : WorldClockRepo = WorldClockRepo()) : ViewModel() {

    val timestamp : LiveData<Resource<WorldClockTimeStamp>> = repo.getTimeStampUtc().toLiveDataWithResource()
}
