package org.inframincer.nationinfo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_nation_detail.*
import java.io.InputStream
import java.io.InputStreamReader

class NationDetailActivity : AppCompatActivity() {
    companion object {
        val EXTRA_NAITON_NAME = "nation_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nation_detail)

        val nation = intent.getStringExtra(EXTRA_NAITON_NAME)
        val data: NationDetailData? = getDataFromName(nation)

        flag_image_view.setImageResource(getResourceId(nation))
        initView(data)
    }

    private fun getDataFromName(selected: String): NationDetailData? {
        val gson: Gson = GsonBuilder().create()
        val inputStream: InputStream = assets.open("nation_data.json")
        val reader: InputStreamReader = InputStreamReader(inputStream)
        val detailData = gson.fromJson(reader, GsonData::class.java)

        for (data in detailData.data) {
            if (selected.equals(data.name)) {
                return data
            }
        }
        return null
    }

    private fun getResourceId(selected: String): Int {
        var resourceId: Int = 0
        when (selected) {
            "Belgium"->{
                resourceId = R.drawable.ic_flag_purple_100_36dp
            }
            "Argentina"->{
                resourceId = R.drawable.ic_flag_purple_300_36dp
            }
            "Brazil"->{
                resourceId = R.drawable.ic_flag_purple_500_36dp
            }
            "Canada"->{
                resourceId = R.drawable.ic_flag_purple_700_36dp
            }
            "China"->{
                resourceId = R.drawable.ic_flag_purple_900_36dp
            }
            else->{
                resourceId = 0
            }
        }
        return resourceId
    }

    private fun initView(data: NationDetailData?) {
        name_text_view.text = data?.name
        capital_text_view.text = data?.capital
        volume_text_view.text = data?.volume
        population_text_view.text = data?.population
        language_text_view.text = data?.language
    }
}