package by.slavintodron.weatherapp.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import by.slavintodron.weatherapp.R
import by.slavintodron.weatherapp.databinding.FragmentTodayWeatherBinding
import by.slavintodron.weatherapp.fragments.interfaces.TodayWeatherListner
import by.slavintodron.weatherapp.weatherOneDayClass.WeatherCurrentDay

private const val ARG_CURRENT_TEMP = "current_temperature"

class TodayWeatherFragment : Fragment() {

    private var _binding: FragmentTodayWeatherBinding? = null
    private val binding get() = _binding!!

    private var weather: WeatherCurrentDay? = null
    private var mListener: TodayWeatherListner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            weather = it.getSerializable(ARG_CURRENT_TEMP) as WeatherCurrentDay
        }
        // mListener?.getTodayWeather();
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTodayWeatherBinding.inflate(inflater, container, false)
        with(binding) {
            textView2.text = (weather?.main?.temp).toString()+"°С | "+ (weather?.weather?.get(0)?.main
                ?: "")
            imageViewCurWeather.setImageResource(R.drawable.wi_day_sunny)
            textViewCity.text = weather?.name +", "+ weather?.sys?.country
            textViewChancesOfParc.text = weather?.clouds?.all.toString()
            textViewPressure.text = weather?.main?.pressure.toString() + "kPa"
            textViewHumid.text = weather?.main?.humidity.toString() + "%"
            textViewWindSpeed.text = weather?.wind?.speed.toString() + "m/s"
            textViewWindDirection.text = weather?.wind?.deg.toString() + "deg"
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListener = if (context is TodayWeatherListner) {
            context as TodayWeatherListner
        } else {
            throw RuntimeException(
                context.toString()
                    .toString() + " must implement OnFragment2DataListener"
            )
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(weatherData: WeatherCurrentDay) =
            TodayWeatherFragment().apply {
                arguments = bundleOf(
                    ARG_CURRENT_TEMP to weatherData,
                )
            }
    }


}