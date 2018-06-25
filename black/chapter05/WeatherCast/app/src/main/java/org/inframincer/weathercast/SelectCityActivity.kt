package org.inframincer.weathercast

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_select_city.*
import org.inframincer.weathercast.data.CityArray
import java.io.InputStreamReader

class SelectCityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_city)

        val inputStream = InputStreamReader(assets.open("current.city.list"))
        val cityData: CityArray = Gson().fromJson(inputStream, CityArray::class.java)

        val adapter = CityListAdapter(this, cityData.city)
        city_list.adapter = adapter
        city_list.setOnItemClickListener{adapterView, view, i, l ->
            val text: TextView = view.findViewById(R.id.city_name_text_view) as TextView
            saveData(view.tag as String, text.text as String)
//            setResult(MainActivity.SELECTED_CITY)
            finish()
        }
    }

    fun saveData(api_id: String, name: String) {
//        val db = DBHandlerAnko(this)
//        db.saveCity(CityData(api_id, name))
    }
}
