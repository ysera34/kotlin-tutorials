package org.inframincer.weathercast

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.inframincer.weathercast.data.WeatherForecast

class WeatherListViewAdapter(val context: Context, val data: ArrayList<WeatherForecast>)
    : RecyclerView.Adapter<CityViewHolder>() {

    var mWeatherData = ArrayList<WeatherForecast>(data)
    var deleteButtonClickListener: View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CityViewHolder {
        val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val mainView = inflater.inflate(R.layout.layout_card_weather, parent, false)
        return CityViewHolder(mainView)
    }

    override fun getItemCount(): Int = mWeatherData.size

    override fun onBindViewHolder(holder: CityViewHolder?, position: Int) {
        val data = mWeatherData[position]
        holder?.bindView(context, data, deleteButtonClickListener)
    }

    fun setDeleteClickListener(l: View.OnClickListener) {
        deleteButtonClickListener = l
    }

    fun updateData(newData: ArrayList<WeatherForecast>) {
        mWeatherData.clear()
        mWeatherData.addAll(newData)
        notifyDataSetChanged()
    }

    fun removeData(apiId: String) {
        for (i in mWeatherData) {
            if (i.current.apiId == apiId) {
                mWeatherData.remove(i)
                break
            }
        }
        notifyDataSetChanged()
    }
}