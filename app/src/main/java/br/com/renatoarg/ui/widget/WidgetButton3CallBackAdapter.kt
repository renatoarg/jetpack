package br.com.renatoarg.ui.widget


class WidgetButton3CallBackAdapter(widgetButton3CallBack: WidgetButton3CallBack) {

    private var callback: WidgetButton3CallBack = widgetButton3CallBack

    fun onButton3Clicked() {
        callback.onButton3Clicked()
    }
}