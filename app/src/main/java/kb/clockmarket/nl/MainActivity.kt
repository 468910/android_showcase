package kb.clockmarket.nl

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kb.clockmarket.nl.api.RetrofitInstance
import kb.clockmarket.nl.api.WorldClockService
import kb.clockmarket.nl.extensions.Status
import kb.clockmarket.nl.service.WorldClockRepo
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        WorldClockRepo().getTimeStampUtc().observe(this, Observer {
           when(it?.status) {
               Status.SUCCESS -> {
                   Timber.d(it.data.toString())
               }
               Status.ERROR -> {
                   Timber.e(it.message)
               }
               Status.LOADING ->{
                   Timber.d("Its loading")

               }
           }
        })

    }
}
