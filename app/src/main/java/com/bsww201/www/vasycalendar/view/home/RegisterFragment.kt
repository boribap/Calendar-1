package com.bsww201.www.vasycalendar.view.home


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bsww201.www.vasycalendar.R
import com.bsww201.www.vasycalendar.view.MainActivity
import kotlinx.android.synthetic.main.fragment_register.view.*

class RegisterFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var registerView = inflater.inflate(R.layout.fragment_register, container, false)

        registerView.s_login_Button.setOnClickListener{
            var mainActivity: MainActivity = activity as MainActivity
            mainActivity.onFragmentChanged(0)
        }

        return registerView
    }
}
