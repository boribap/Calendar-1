package com.bsww201.www.vasycalendar.view

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.bsww201.www.vasycalendar.R
import com.bsww201.www.vasycalendar.view.services.AnalysisFragment
import com.bsww201.www.vasycalendar.view.services.RecordFragment
import com.bsww201.www.vasycalendar.view.services.UserFragment
import kotlinx.android.synthetic.main.activity_services.*

class ServicesActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_record -> {
                replace(RecordFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_analysis -> {
                replace(AnalysisFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_user -> {
                replace(UserFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)

        navigation_services.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        replace(RecordFragment())
    }

    private fun replace(fragment: Fragment) {
        val fragmentTransaction= supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_service,fragment)
        fragmentTransaction.commit()
    }
}
