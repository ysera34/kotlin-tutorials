package org.inframincer.weathercast

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import org.inframincer.weathercast.data.WeatherForecast

class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val description: TextView = itemView.findViewById(R.id.description_text_view) as TextView
    val currentTemperature: TextView = itemView.findViewById(R.id.current_temperature_text_view) as TextView
    val highLowTemperature: TextView = itemView.findViewById(R.id.high_low_temperature_text_view) as TextView
    val cityName: TextView = itemView.findViewById(R.id.city_name_text_view) as TextView
    val humidity: TextView = itemView.findViewById(R.id.humidity_text_view) as TextView
    val cloudy: TextView = itemView.findViewById(R.id.cloudy_text_view) as TextView
    val wind: TextView = itemView.findViewById(R.id.wind_text_view) as TextView
    val deleteButton : ImageButton = itemView.findViewById(R.id.delete_image_button) as ImageButton

    fun bindView(context: Context, data: WeatherForecast, deleteClick: View.OnClickListener?) {
        with(data) {
            description.text = data.current[0].description
//            (data.iconUrl + data.current[0].icon + ".png")
            currentTemperature.setCompoundDrawables(null, null, null, null)
            currentTemperature.text = String.format(context.resources.getString(R.string.current_temp), data.current.main.temp)

            val format: String = context.resources.getString(R.string.min_max_temp)
            highLowTemperature.text = String.format(format, data.current.main.tempMin, data.current.main.tempMax)
            cityName.text = data.current.cityName
            cloudy.text = String.format(context.resources.getString(R.string.percent), data.current.clouds.all)
            humidity.text = String.format(context.resources.getString(R.string.percent), data.current.main.humidity)
            wind.text = data.current.wind.speed
//            forecast.setView(data.week.list, data.iconUrl)
            deleteButton.setOnClickListener(deleteClick)
            deleteButton.tag = data.current.apiId
        }
    }
}