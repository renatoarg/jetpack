package br.com.renatoarg.ui.widget


class WidgetButton2CallBackAdapter(widgetButton2CallBack: WidgetButton2CallBack) {

    private var callback: WidgetButton2CallBack = widgetButton2CallBack

    fun onButton2Clicked() {
        callback.onButton2Clicked()
    }
}