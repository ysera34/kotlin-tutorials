package org.inframincer.nationinfo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

class NationListActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nation_list)

        val nationRecyclerView = findViewById(R.id.nation_recycler_view) as RecyclerView
        nationRecyclerView.layoutManager = LinearLayoutManager(this)

        val nationAdapter = NationAdapter(this, listOf(
            NationData(R.mipmap.ic_launcher_round, "Korea", "Seoul"),
            NationData(R.mipmap.ic_launcher_round, "Korea", "Seoul"),
            NationData(R.mipmap.ic_launcher_round, "Korea", "Seoul"),
            NationData(R.mipmap.ic_launcher_round, "Korea", "Seoul"),
            NationData(R.mipmap.ic_launcher_round, "Korea", "Seoul")
        ))

        nationRecyclerView.adapter = nationAdapter
    }

    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
