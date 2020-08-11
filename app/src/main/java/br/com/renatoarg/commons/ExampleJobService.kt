package br.com.renatoarg.commons

import android.app.job.JobParameters
import android.app.job.JobService
import timber.log.Timber

class ExampleJobService : JobService() {

    var jobCancelled = false

    override fun onStartJob(params: JobParameters?): Boolean {
        Timber.d("onStartJob:")
        doBackgroundWork(params)
        return true
    }

    private fun doBackgroundWork(params: JobParameters?) {
        params?.let {
            Thread(Runnable {
                for (i in 0..10) {
                    if (!jobCancelled) {
                        Timber.d("run: $i")
                        Thread.sleep(1000)
                    }
                }
                Timber.d("job finished:")
                jobFinished(params, false)
            }).start()
        }
    }


    override fun onStopJob(params: JobParameters?): Boolean {
        Timber.d("onStopJob:")
        jobCancelled = true
        return true
    }

}