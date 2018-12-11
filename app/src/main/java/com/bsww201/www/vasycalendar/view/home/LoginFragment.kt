package com.bsww201.www.vasycalendar.view.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bsww201.www.vasycalendar.R
import com.bsww201.www.vasycalendar.view.MainActivity
import com.bsww201.www.vasycalendar.view.ServicesActivity
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*

class LoginFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val loginView  = inflater.inflate(R.layout.fragment_login, container, false)

        loginView.sign_up_Button.setOnClickListener {
            var mainActivity:MainActivity = activity as MainActivity
            mainActivity.onFragmentChanged(1)
        }

        loginView.login_Button.setOnClickListener{
            var servicesActivity = Intent(context, ServicesActivity::class.java)
            startActivity(servicesActivity)
        }

        return loginView
    }
}