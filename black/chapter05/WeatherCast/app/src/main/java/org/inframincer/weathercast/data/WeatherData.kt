package org.inframincer.weathercast.data

import com.google.gson.annotations.SerializedName

data class DayData(
        val weather: ArrayList<WeatherData>,
        val main: MainData,
        val wind: WindData,
        val clouds: CloudData,
        val rain: RainData,
        var cityName: String,
        @SerializedName("api_id") var apiId: String) {

    operator fun get(position:Int): WeatherData = weather[position]
}

data class WeekData(val list: ArrayList<WeekList>)

data class WeekList(
        val dt: String,
        val weather: ArrayList<WeatherData>,
        val main: MainData,
        val clouds: CloudData,
        @SerializedName("dt_txt") val dtText: String)

data class WeatherData(
        val main: String,
        val description: String,
        val icon: String)

data class MainData(
        val temp: String,
        @SerializedName("temp_min") val tempMin: String,
        @SerializedName("temp_max") val tempMax: String,
        val humidity: String)

data class CloudData(val all: String)
data class RainData(@SerializedName("3h") val rain: Int)
data class WindData(val speed: String)
data class WeatherForecast(val current: DayData, val week: WeekData, val iconUrl: String)