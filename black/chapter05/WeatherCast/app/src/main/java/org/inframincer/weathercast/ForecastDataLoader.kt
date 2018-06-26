package org.inframincer.weathercast

import android.content.AsyncTaskLoader
import android.content.Context
import com.google.gson.Gson
import org.inframincer.weathercast.data.CityData
import org.inframincer.weathercast.data.DayData
import org.inframincer.weathercast.data.WeatherForecast
import org.inframincer.weathercast.data.WeekData
import java.io.InputStreamReader
import java.net.URL

class ForecastDataLoader(context: Context, private val cities: ArrayList<CityData>)
    : AsyncTaskLoader<ArrayList<WeatherForecast>>(context) {

    val API_KEY = ""
    val CURRENT_URL: String = "http://api.openweathermap.org/data/2.5/weather?id="
    val FORECAST_URL: String = "http://api.openweathermap.org/data/2.5/forecast?id="
    val ICON_URL: String = "http://openweathermap.org/img/w"

    override fun loadInBackground(): ArrayList<WeatherForecast> {
        val CITY_WEATHER = ArrayList<WeatherForecast>()
        cities.forEach {
            val currentUrl = CURRENT_URL + it._id + "&units=metric&APPID=$API_KEY"
            val readData = URL(currentUrl).readText()
            val current: DayData = Gson().fromJson(readData, DayData::class.java)
            current.cityName = it.name
            current.apiId = it._id

            val foreUrl = FORECAST_URL + it._id + "&units=metric&APPID=$API_KEY"
            val url = URL(foreUrl)
            val inputStream = InputStreamReader(url.openStream())

            val week: WeekData = Gson().fromJson(inputStream, WeekData::class.java)
            val forecast: WeatherForecast = WeatherForecast(current, week, ICON_URL)
            CITY_WEATHER.add(forecast)
        }
        return CITY_WEATHER
    }
}