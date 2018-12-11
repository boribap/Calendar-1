package com.bsww201.www.vasycalendar.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import com.bsww201.www.vasycalendar.R
import com.bsww201.www.vasycalendar.view.home.LoginFragment
import com.bsww201.www.vasycalendar.view.home.RegisterFragment

class MainActivity : AppCompatActivity() {

    var fragment_login :  Fragment = LoginFragment()
    var fragment_register : Fragment = RegisterFragment()
    var fragment_tran : FragmentTransaction? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onFragmentChanged(0)
    }

    fun onFragmentChanged(index : Int){
        //fragment_manager = fragmentManager()

        if (index == 0){
            val fragment_manager : FragmentManager = supportFragmentManager
            fragment_tran = fragment_manager.beginTransaction()
            fragment_tran!!.replace(R.id.frame_home, fragment_login)
            fragment_tran!!.commit()
        }
        else if (index == 1){
            val fragment_manager : FragmentManager = supportFragmentManager
            fragment_tran = fragment_manager.beginTransaction()
            fragment_tran!!.replace(R.id.frame_home, fragment_register)
            fragment_tran!!.commit()
        }
    }
}
