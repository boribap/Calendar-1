package com.bsww201.www.vasycalendar.utils

import java.util.regex.Pattern

class CheckVaild {

    // 회원가입 입력 폼에 대한 제한 (이름)
    private fun checkNameForm(name : String?) : Boolean {
        if (name == null){
            return false
        }
        val regex = "^[_a-zA-Z가-힣0-9]{2,6}"
        val patten = Pattern.compile(regex)
        return patten.matcher(name).matches()
    }

    // 회원가입 입력 폼에 대한 제한 (이메일)
    fun checkEmailForm(email : String?) : Boolean {
        if (email == null){
            return false
        }
        val regex = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$"
        val pattern = Pattern.compile(regex)
        return pattern.matcher(email).matches()
    }

    // 회원가입 입력 폼에 대한 제한 (비밀번호)
    fun checkPasswordForm(password : String?) : Boolean {
        if (password == null){
            return false
        }
        //val regex = "^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-zA-Z]).{8,20}$"
        val regex = "^[_a-zA-Z가-힣0-9]{2,18}"
        val pattern = Pattern.compile(regex)
        return pattern.matcher(password).matches()
    }

    // 로그인에 대한 유효성 검사 (전체)
    fun isValidLogin(emailEditText:String, passwordEditText:String) : Boolean {

        if (!checkEmailForm(email = emailEditText)){
            //Toast.makeText(,"이메일 형식이 잘못되었습니다.", Toast.LENGTH_SHORT).show()
            return false
        }
        if (!checkPasswordForm(password = passwordEditText)){
            //Toast.makeText(,"비밀번호 형식이 잘못되었습니다.", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    // 회원가입에 대한 유효성 검사 (전체)
    fun isValidRegister(nameEditText : String, emailEditText: String, passwordEditText: String) : Boolean {
        if (!checkNameForm(name = nameEditText)) {
            //Toast.makeText(context,"이름 형식이 잘못되었습니다.", Toast.LENGTH_SHORT).show()
            return false
        }
        if (!checkEmailForm(email = emailEditText)){
            //Toast.makeText(context,"이메일 형식이 잘못되었습니다.", Toast.LENGTH_SHORT).show()
            return false
        }
        if (!checkPasswordForm(password = passwordEditText)){
            //Toast.makeText(context,"비밀번호 형식이 잘못되었습니다.", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }
}