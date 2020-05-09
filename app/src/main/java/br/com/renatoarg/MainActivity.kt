package br.com.renatoarg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.d("onCreate:")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
