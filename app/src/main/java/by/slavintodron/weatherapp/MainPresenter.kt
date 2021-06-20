package by.slavintodron.weatherapp

import android.util.Log
import by.slavintodron.weatherapp.MainContract.Presenter

class MainPresenter(  //Компоненты MVP приложения
    private val mView: MainContract.View
) : Presenter {
    private val mRepository: MainContract.Repository

    override fun onButtonWasClicked() {
        val message = mRepository.loadMessage()
        mView.showText(message)
        Log.d(TAG, "onButtonWasClicked()")
    }

    override fun todayWeather() {
        val weather = mRepository.getWeather()
        mView.showWeather(weather)
    }

    override fun onDestroy() {}

    companion object {
        private const val TAG = "MainPresenter"
    }

    //Обрати внимание на аргументы конструктора - мы передаем экземпляр View, а Repository просто создаём конструктором.
    init {
        mRepository = MainRepository()
        Log.d(TAG, "Constructor")
    }
}