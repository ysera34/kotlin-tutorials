package org.inframincer.nationinfo

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * Created by yoon on 2018. 6. 17..
 */
class NationViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

    init {
        view.setOnClickListener(this)
    }

    private var mNationData: NationData? = null

    private val flagImageView: ImageView = view.findViewById(R.id.flag_image_view) as ImageView
    private val nameTextView: TextView = view.findViewById(R.id.name_text_view) as TextView
    private val capitalTextView: TextView = view.findViewById(R.id.capital_text_view) as TextView

    fun bindNationView(nationData: NationData) {
        mNationData = nationData
        flagImageView.setImageResource(nationData.flagResId)
        nameTextView.text = nationData.name
        capitalTextView.text = nationData.capital
    }

    override fun onClick(v: View?) {
        Toast.makeText(v?.context, mNationData?.name, Toast.LENGTH_SHORT).show()
        val intent = Intent(v?.context, NationDetailActivity::class.java)
        intent.putExtra(NationDetailActivity.EXTRA_NAITON_NAME, mNationData?.name)
        v?.context?.startActivity(intent)
    }
}