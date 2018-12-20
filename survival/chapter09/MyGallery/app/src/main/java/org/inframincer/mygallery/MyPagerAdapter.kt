package org.inframincer.mygallery

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * Created by ysera34 on 2018. 12. 21..
 */
class MyPagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

    private val items = ArrayList<Fragment>()

    override fun getItem(position: Int): Fragment {
        return items[position]
    }

    override fun getCount(): Int {
        return items.size
    }

    fun updateFragments(items: List<Fragment>) {
        this.items.addAll(items)
    }
}