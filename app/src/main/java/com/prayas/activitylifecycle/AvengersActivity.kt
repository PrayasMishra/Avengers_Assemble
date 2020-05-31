package com.prayas.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.EditText

class AvengersActivity : AppCompatActivity() {

    lateinit var etMessage : EditText
    lateinit var btnSend : Button
    lateinit var sharedPreferences: SharedPreferences
    var titleName : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        setContentView(R.layout.activity_avengers)

        titleName = sharedPreferences.getString("Title","The Avengers")
        title = titleName

        etMessage = findViewById(R.id.etMessage)
        btnSend = findViewById(R.id.btnSend)

        btnSend.setOnClickListener{
            val message = etMessage.text.toString()
            val intent = Intent(this@AvengersActivity,MessageActivity::class.java)
            intent.putExtra("msg", message)
            startActivity(intent)
        }
    }

   }
