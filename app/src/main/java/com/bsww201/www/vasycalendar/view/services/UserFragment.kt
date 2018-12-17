package com.bsww201.www.vasycalendar.view.services


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bsww201.www.vasycalendar.R
import com.bsww201.www.vasycalendar.utils.App
import com.bsww201.www.vasycalendar.view.MainActivity
import kotlinx.android.synthetic.main.fragment_user.view.*

class UserFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var userView = inflater.inflate(R.layout.fragment_register, container, false)
        var mainActivity: MainActivity = activity as MainActivity

        userView.btn_logout.setOnClickListener {
            var pref : SharedPreferences = context!!.getSharedPreferences("pref", Context.MODE_PRIVATE)
            var editor : SharedPreferences.Editor = pref.edit()
            editor.clear()
            editor.commit()

            Log.e("지우고 난 후 액세스 토큰", App.prefs.access_token)
            Log.e("지우고 난 후 리프레시 토큰", App.prefs.refresh_token)

            mainActivity.onFragmentChanged(0)
        }

        return userView
    }
}
