package com.prayas.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    lateinit var etMobileNumber : EditText
    lateinit var etPassword : EditText
    lateinit var btnLogin : Button
    lateinit var txtForgotPassword : TextView
    lateinit var txtRegister : TextView
    private val validMobileNumber = "0123456789"
    private val validPassword = arrayListOf<String>("tony","steve","bruce","thanos")
    lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn",false)

        if (isLoggedIn) {
            val intent = Intent(this@LoginActivity,AvengersActivity::class.java)
            startActivity(intent)
            finish()
        }

        title = "Login"
        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)

        btnLogin.setOnClickListener{
            val mobileNumber = etMobileNumber.text.toString()
            val password = etPassword.text.toString()
            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)
            var nameOfAvenger : String
            if (mobileNumber == validMobileNumber)
            {
                when (password) {
                    validPassword[0] -> {
                        nameOfAvenger = "Tony Stark / Iron Man"
                        savePreferences(nameOfAvenger)
                        startActivity(intent)
                    }

                    validPassword[1] -> {
                        nameOfAvenger = "Captain Steven Rogers / Captain America"
                        savePreferences(nameOfAvenger)
                        startActivity(intent)
                    }

                    validPassword[2] -> {
                        nameOfAvenger = "Dr. Bruce Banner / The Hulk"
                        savePreferences(nameOfAvenger)
                        startActivity(intent)
                    }

                    validPassword[3] -> {
                        nameOfAvenger = "The Avengers"
                        savePreferences(nameOfAvenger)
                        startActivity(intent)
                    }
                }
            }
            else
            {
                Toast.makeText(this@LoginActivity
                    , "Incorrect details"
                    , Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    fun savePreferences(title: String){
        sharedPreferences.edit().putBoolean("IsLoggedIn",true).apply()
        sharedPreferences.edit().putString("Title",title).apply()
    }
}
