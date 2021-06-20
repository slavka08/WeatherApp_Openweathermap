package by.slavintodron.weatherapp

import by.slavintodron.weatherapp.weatherOneDayClass.WeatherCurrentDay
import com.google.gson.Gson

class MainRepository : MainContract.Repository {
    override fun loadMessage(): String {
        return "azaazaza"
    }

    override fun getWeather(): WeatherCurrentDay {
        val jsonStr = """
    {"coord":{"lon":24.0232,"lat":49.8383},"weather":[{"id":803,"main":"Clouds","description":"broken clouds","icon":"04d"}],"base":"stations","main":{"temp":24.13,"feels_like":24.27,"temp_min":23,"temp_max":25.59,"pressure":1016,"humidity":64},"visibility":10000,"wind":{"speed":3,"deg":100},"clouds":{"all":75},"dt":1624180266,"sys":{"type":1,"id":8909,"country":"UA","sunrise":1624155314,"sunset":1624214142},"timezone":10800,"id":702550,"name":"Lviv","cod":200}
    """.trimIndent()

        val weather: WeatherCurrentDay =
            Gson().fromJson(jsonStr, WeatherCurrentDay::class.java)
        println(weather)
        return weather
    }
}