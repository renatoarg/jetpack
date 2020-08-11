package br.com.renatoarg.ui.home

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context.JOB_SCHEDULER_SERVICE
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import br.com.renatoarg.R
import br.com.renatoarg.commons.ExampleJobService
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("onViewCreated:")


        button.setOnClickListener {
            val componentName = ComponentName(requireContext(), ExampleJobService::class.java)
            val jobInfo = JobInfo.Builder(123, componentName)
                .setRequiresCharging(false)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setPersisted(true)
                .setPeriodic(20*1000)
                .build()

            val scheduler = requireContext().getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
            val resultCode = scheduler.schedule(jobInfo)
            if(resultCode == JobScheduler.RESULT_SUCCESS) {
                Timber.d("job scheduled")
            } else {
                Timber.d("job scheduled failed")
            }
        }

        button2.setOnClickListener {
            val scheduler = requireContext().getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
            scheduler.cancel(123)
        }
    }

}
