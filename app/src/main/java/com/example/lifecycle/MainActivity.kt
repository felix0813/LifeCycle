package com.example.lifecycle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import com.example.lifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   private val tag="felix"
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        if(savedInstanceState!=null){
            val tempdata=savedInstanceState
            Log.d("felix",tempdata.toString())
        }
        Log.d(tag,"onCreate")
        Log.d(tag,this.toString())
        setContentView(R.layout.activity_main)
        val button1: Button =findViewById(R.id.button1)
        button1.setOnClickListener{
            val intent= Intent(this,NormalActivity::class.java)
            startActivity(intent)
        }
        val button2: Button =findViewById(R.id.button2)
        button2.setOnClickListener{
            val intent= Intent(this,DialogActivity::class.java)
            startActivity(intent)
        }
        val button7:Button=findViewById(R.id.button7)
        button7.setOnClickListener{
            val intent=Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
        val button=findViewById<Button>(R.id.button)
        button.setOnClickListener {
            startActivity(Intent(this,contentprovider_test::class.java))
        }
    }
    override fun onStart(){
        super.onStart()
        Log.d(tag,"onStart")
    }
    override fun onResume(){
        super.onResume()
        Log.d(tag,"onResume")
    }
    override fun onStop(){
        super.onStop()
        Log.d(tag,"onStop")
    }
    override fun onRestart(){
        super.onRestart()
        Log.d(tag,"onRestart")
    }
    override fun onPause(){
        super.onPause()
        Log.d(tag,"onPause")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.d(tag,"onDestroy")
    }
}