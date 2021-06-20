package by.slavintodron.weatherapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import by.slavintodron.weatherapp.MainContract.Presenter
import by.slavintodron.weatherapp.databinding.ActivityMainBinding
import by.slavintodron.weatherapp.fragments.TodayWeatherFragment
import by.slavintodron.weatherapp.fragments.interfaces.TodayWeatherListner
import by.slavintodron.weatherapp.weatherOneDayClass.WeatherCurrentDay


private var mPresenter: Presenter? = null

class MainActivity : AppCompatActivity(), MainContract.View, TodayWeatherListner {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        mPresenter = MainPresenter(this)
        mPresenter?.todayWeather()
    }

    override fun showText(message: String) {
     //   binding.textView.text = message
    }

    override fun showWeather(weather: WeatherCurrentDay) {
        openFirstFragment(weather = weather)
    }

    private fun openFirstFragment(weather: WeatherCurrentDay) {
        val firstFragment: Fragment = TodayWeatherFragment.newInstance(weatherData = weather)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, firstFragment)
        transaction.commit()
    }

    override fun onTodayWeather(CurrentTemp: Int) {
        TODO("Not yet implemented")
    }

    override fun getTodayWeather() {
        mPresenter?.todayWeather()
    }

}