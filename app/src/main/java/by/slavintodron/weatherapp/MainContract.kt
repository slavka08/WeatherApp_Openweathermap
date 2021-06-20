package by.slavintodron.weatherapp

import by.slavintodron.weatherapp.weatherOneDayClass.WeatherCurrentDay

interface MainContract {
    interface View {
        fun showText(message: String)
        fun showWeather(weather: WeatherCurrentDay)
    }

    interface Presenter {
        fun onButtonWasClicked()
        fun todayWeather()
        fun onDestroy()
    }

    interface Repository {
        fun loadMessage(): String
        fun getWeather(): WeatherCurrentDay
    }
}