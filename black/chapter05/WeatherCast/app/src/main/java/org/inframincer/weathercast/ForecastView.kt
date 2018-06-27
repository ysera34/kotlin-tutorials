package org.inframincer.weathercast

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.inframincer.weathercast.data.WeekList
import org.jetbrains.anko.find
import java.text.SimpleDateFormat
import java.util.*

class ForecastView : LinearLayout {

    var mainView: View? = null
    var mScrollView: HorizontalScrollView? = null

    constructor(context: Context) : super(context)
    constructor(context: Context, attributes: AttributeSet) : super(context, attributes)

    init {
        mainView = LinearLayout(context)
        mScrollView = HorizontalScrollView(context)
        mScrollView?.scrollBarSize = 2
        mScrollView?.addView(mainView)
        addView(mScrollView)
    }

    private fun getForecastDate(time: Long): String {
        val format: SimpleDateFormat = SimpleDateFormat("dd HH", Locale.KOREA)
        return format.format(time * 1000L)
    }

    private fun createItemView(): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return inflater.inflate(R.layout.layout_week_weather_view, null, false)
    }

    private fun getDataIndex(data: ArrayList<WeekList>, iconUrl: String) {
        val start = getDataIndex(data)
        (mainView as LinearLayout).removeAllViews()
        for (i in start..(start + 15)) {
            val layout: View = createItemView()

            val weekTextView: TextView = layout.findViewById(R.id.week_text_view) as TextView
            weekTextView.text = getForecastDate(data[i].dt.toLong())

            val iconImageView: ImageView = layout.findViewById(R.id.weather_icon_image_view) as ImageView
            Picasso.get().load(iconUrl + data[i].weather[0].icon + ".png").into(iconImageView)

            val temperatureTextView: TextView = layout.findViewById(R.id.average_temperature_text_view) as TextView
            temperatureTextView.text = "${data[i].main.temp} \\u2103"

            (mainView as LinearLayout).addView(layout)
        }
    }
}