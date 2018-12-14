package com.bsww201.www.vasycalendar.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.util.Log
import android.widget.Toast
import com.bsww201.www.vasycalendar.R
import com.bsww201.www.vasycalendar.utils.App
import com.bsww201.www.vasycalendar.utils.JWTUtils
import com.bsww201.www.vasycalendar.utils.User
import com.bsww201.www.vasycalendar.view.home.LoginFragment
import com.bsww201.www.vasycalendar.view.home.RegisterFragment
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    var fragment_login :  Fragment = LoginFragment()
    var fragment_register : Fragment = RegisterFragment()
    var fragment_tran : FragmentTransaction? = null

    // 전환할 인텐트
    var servicesActivity = Intent(this, ServicesActivity::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("저장된 값", App.prefs.refresh_token)

        // 자동 로그인 구현
        // 토큰이 유효한지 아닌지 확인해주기 --> 유효하면 ServicesActivity로 전환 / 만료되었으면 로그인 fragment 실행
        if (JWTUtils().compareExp(App.prefs.refresh_token)){
            // exp 유효
            Log.e("유효 : ", "0")

            // ServicesActivity로 전환
            startActivity(servicesActivity)
        } else {
            // exp 만료
            Log.e("유효 : ", "X")

            // 로그인 fragment 띄우기
            onFragmentChanged(0)
        }
    }

    // Fragment 변경 함수
    // TODO: ServicesActivity는 replace함수를 만들었음 (비교해보고 한개로 통일하기)
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
