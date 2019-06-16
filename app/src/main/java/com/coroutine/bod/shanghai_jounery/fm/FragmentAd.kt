package com.coroutine.bod.shanghai_jounery.fm

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.coroutine.bod.shanghai_jounery.R
import kotlinx.android.synthetic.main.fragment_aaa.*

class FragmentAd : LazyLoadFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(inflater.context).inflate(R.layout.fragment_aaa, container,false)
    }

    override fun loadData() {
        Log.d("BobFm", "try to load data " + javaClass.simpleName)
        textView.text = javaClass.simpleName
    }
}
