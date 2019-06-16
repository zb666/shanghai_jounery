package com.coroutine.bod.shanghai_jounery.fm.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.coroutine.bod.shanghai_jounery.fm.FragmentAd

class FmAdapter constructor(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    override fun getCount(): Int {
        return 10
    }

    override fun getItem(p0: Int): Fragment {
        return FragmentAd()
    }
}