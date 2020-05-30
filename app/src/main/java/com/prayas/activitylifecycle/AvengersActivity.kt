package com.prayas.activitylifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.EditText

class AvengersActivity : AppCompatActivity() {

    lateinit var etMessage : EditText
    lateinit var btnSend : Button

    var titleName : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avengers)

        if (intent != null)
        {
            titleName = intent.getStringExtra("name")
        }

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
