package com.coroutine.bod.shanghai_jounery

import android.arch.lifecycle.ViewModelProvider
import android.content.Intent
import android.os.*
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import android.util.Log
import com.bumptech.glide.Glide
import com.coroutine.bod.shanghai_jounery.fm.LazyLoadFragment
import com.coroutine.bod.shanghai_jounery.fm.adapter.FmAdapter
import kotlinx.android.synthetic.main.layout_constraint.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_constraint)
        calculate()

    }

    private fun calculate() {

        val fmAdapter = FmAdapter(supportFragmentManager)
        viewPager.adapter = fmAdapter

        Looper.myQueue().addIdleHandler(object : MessageQueue.IdleHandler {
            override fun queueIdle(): Boolean {
                val lazyLoadFm = supportFragmentManager.fragments as? LazyLoadFragment
                lazyLoadFm?.callWhenIdle()
                return false
            }

        })
    }
}
