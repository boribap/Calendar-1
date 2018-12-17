package com.bsww201.www.vasycalendar.view.home


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.bsww201.www.vasycalendar.R
import com.bsww201.www.vasycalendar.api.ServiceAPI
import com.bsww201.www.vasycalendar.utils.CheckVaild
import com.bsww201.www.vasycalendar.utils.ResponseJSON
import com.bsww201.www.vasycalendar.utils.User
import com.bsww201.www.vasycalendar.view.MainActivity
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.regex.Pattern

class RegisterFragment : Fragment() {

    private var nameEditText: String = ""
    private var emailEditText:String = ""
    private var passwordEditText:String = ""

    // retrofit : 서버로 전달할 데이터의 클래스 객체 생성
    private var user:User = User()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var registerView = inflater.inflate(R.layout.fragment_register, container, false)
        var mainActivity: MainActivity = activity as MainActivity

        // 여기버튼에 회원가입 하는 로직 코드 구현
        // 마지막에 onFragmentChanged(0)을 설정해서 넘기기
        registerView.s_sign_up_Button.setOnClickListener {

            nameEditText = s_name_Text.text.toString()
            emailEditText = s_email_Text.text.toString()
            passwordEditText = s_password_Text.text.toString()

            if (CheckVaild().isValidRegister(nameEditText, emailEditText, passwordEditText)){
                // 회원가입 실패
                Toast.makeText(context,"입력 형식이 잘못되었습니다.", Toast.LENGTH_SHORT).show()
            } else {
                // 회원가입 성공 --> 정보를 서버로 전달
                Log.e("회원가입 정보 : " , nameEditText + " " + emailEditText + " " + passwordEditText)

                // retrofit : --> 정보를 서버로 전달
                var baseurl = "http://192.168.0.4:7260/"
                var retrofit : Retrofit = Retrofit.Builder()
                        .baseUrl(baseurl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

                var serviceAPI : ServiceAPI = retrofit.create(ServiceAPI::class.java)
                user = user.User(nameEditText, emailEditText, passwordEditText)
                var call : Call<List<ResponseJSON>> = serviceAPI.signUpData(user)

                call.enqueue(object : Callback<List<ResponseJSON>> {
                    override fun onResponse(call: Call<List<ResponseJSON>>?, response: Response<List<ResponseJSON>>?) {

                        var result1 : Int? = response?.code()
                        Log.e("응답 코드 ", result1.toString())

                        if (response!!.isSuccessful()){
                            var jsonobj : List<ResponseJSON> = response.body()
                            var res_status : String? = jsonobj[0].getstatus()
                            Log.e("응답 메세지", res_status)

                            if(res_status == "DUPL_EMAIL"){
                                Toast.makeText(context,"중복되는 이메일이 존재합니다.", Toast.LENGTH_SHORT).show()
                                s_email_Text.text.clear()
                            }else {
                                // 회원가입 끝
                                Toast.makeText(context, "회원 가입 완료", Toast.LENGTH_SHORT).show()
                                // 로그인 페이지로 넘어가기
                                mainActivity.onFragmentChanged(0)
                            }
                        }
                    }

                    override fun onFailure(call: Call<List<ResponseJSON>>?, t: Throwable?) {
                        Log.e("에러 남", t.toString())
                    }
                })
            }
        }

        // 로그인 페이지로 이동
        registerView.s_login_Button.setOnClickListener{
            mainActivity.onFragmentChanged(0)
        }

        return registerView
    }
}
