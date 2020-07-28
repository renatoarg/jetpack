package br.com.renatoarg.ui.widget


class WidgetButton1CallBackAdapter(widgetButton1CallBack: WidgetButton1CallBack) {

    private var callback: WidgetButton1CallBack = widgetButton1CallBack

    fun onButton1Clicked() {
        callback.onButton1Clicked()
    }
}