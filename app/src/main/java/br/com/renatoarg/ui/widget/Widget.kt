package br.com.renatoarg.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.renatoarg.R
import kotlinx.android.synthetic.main.widget.view.*
import timber.log.Timber

class Widget : ConstraintLayout {

    private lateinit var callBackAdapter1: WidgetButton1CallBackAdapter
    private lateinit var callBackAdapter2: WidgetButton2CallBackAdapter
    private lateinit var callBackAdapter3: WidgetButton3CallBackAdapter

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
            if (this::callBackAdapter1.isInitialized) {
                callBackAdapter1.onButton1Clicked()
            }
        }
        button2.setOnClickListener {
            if (this::callBackAdapter2.isInitialized) {
                callBackAdapter2.onButton2Clicked()
            }
        }
        button3.setOnClickListener {
            if (this::callBackAdapter3.isInitialized) {
                callBackAdapter3.onButton3Clicked()
            }
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

    fun addButton1CallBack(widgetButton1CallBackAdapter: WidgetButton1CallBackAdapter) {
        callBackAdapter1 = widgetButton1CallBackAdapter
    }

    fun addButton2CallBack(widgetButton2CallBackAdapter: WidgetButton2CallBackAdapter) {
        callBackAdapter2 = widgetButton2CallBackAdapter
    }

    fun addButton3CallBack(widgetButton3CallBackAdapter: WidgetButton3CallBackAdapter) {
        callBackAdapter3 = widgetButton3CallBackAdapter
    }
}