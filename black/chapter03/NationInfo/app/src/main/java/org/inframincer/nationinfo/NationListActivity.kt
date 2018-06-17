package org.inframincer.nationinfo

import android.content.res.TypedArray
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class NationListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nation_list)

        val nationRecyclerView = findViewById(R.id.nation_recycler_view) as RecyclerView
        nationRecyclerView.layoutManager = LinearLayoutManager(this)

        var typedArray: TypedArray = resources.obtainTypedArray(R.array.nation_flags)

        val nationAdapter = NationAdapter(this, listOf(
            NationData(typedArray.getResourceId(0, -1), "Belgium", "Brussels"),
            NationData(typedArray.getResourceId(1, -1), "Argentina", "Buenos Aires"),
            NationData(typedArray.getResourceId(2, -1), "Brazil", "Brasília"),
            NationData(typedArray.getResourceId(3, -1), "Canada", "Ottawa"),
            NationData(typedArray.getResourceId(4, -1), "China", "Beijing")
        ))

        nationRecyclerView.adapter = nationAdapter
    }
}
