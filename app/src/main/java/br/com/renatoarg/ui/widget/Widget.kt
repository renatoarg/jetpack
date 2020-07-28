package br.com.renatoarg.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import br.com.renatoarg.R
import br.com.renatoarg.ui.home.HomeFragment
import br.com.renatoarg.ui.other.OtherFragment
import kotlinx.android.synthetic.main.widget.view.*
import timber.log.Timber

class Widget : ConstraintLayout {

    private lateinit var widgetInterface: WidgetInterface

    constructor(context: Context) : super(context) {
        bind(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        bind(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        bind(context)
    }

    private fun bind(context: Context) {
        Timber.d("bind: ")
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.widget, this)

        button1.setOnClickListener {
            widgetInterface.onButton1Clicked()
        }
        button2.setOnClickListener {
            widgetInterface.onButton2Clicked()
        }
        button3.setOnClickListener {
            widgetInterface.onButton3Clicked()
        }
    }

    fun setFragment(fragment: Fragment) {
        if(fragment is OtherFragment) {
            widgetInterface = fragment as OtherFragment
        } else if(fragment is HomeFragment) {
            widgetInterface = fragment as HomeFragment
        }
    }

    fun showButton1() {
        button1.visibility = View.VISIBLE
    }

    fun showButton2() {
        button2.visibility = View.VISIBLE
    }

    fun showButton3() {
        button3.visibility = View.VISIBLE
    }
}