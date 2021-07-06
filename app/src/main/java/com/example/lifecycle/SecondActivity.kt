package com.example.lifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("felix",this.toString())
        setContentView(R.layout.activity_second)
        val button4: Button =findViewById(R.id.button4)
        button4.setOnClickListener{
            finish()
        }
        val button5:Button=findViewById(R.id.button5)
        button5.setOnClickListener{
            val intent= Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
        val button6:Button=findViewById(R.id.button6)
        button6.setOnClickListener{
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        val button8:Button=findViewById(R.id.button8)
        button8.setOnClickListener {
            val intent=Intent(this,ThirdActivity::class.java)
            startActivity(intent)
        }
    }
}