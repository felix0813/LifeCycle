package com.example.lifecycle


import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.core.content.contentValuesOf

class contentprovider_test : AppCompatActivity() {
    val uristr="content://com.example.viewtest.provider/contacts"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contentprovider_test)
        val button1=findViewById<Button>(R.id.add_button)
        button1.setOnClickListener {
            val uri= Uri.parse(uristr)
            val name=findViewById<EditText>(R.id.add_name).text.toString()
            val phone= findViewById<EditText>(R.id.add_phone).text.toString()
            val id=phone.substring(phone.length-4).toInt()
            val values= contentValuesOf("name" to name,"phone" to phone,"id" to id)
            contentResolver.insert(uri,values)
        }
        val button2=findViewById<Button>(R.id.delete_button)
        button2.setOnClickListener {
            val id=findViewById<EditText>(R.id.delete_id).text.toString()
            val uri=Uri.parse("$uristr/$id")
            contentResolver.delete(uri,null,null)
        }
        val button3=findViewById<Button>(R.id.query_button)
        button3.setOnClickListener {
            val id=findViewById<EditText>(R.id.query_id).text.toString()
            val uri=Uri.parse("$uristr/$id")
            contentResolver.query(uri,null,null,null,null)?.apply {
                Log.e("felix", count.toString())
                while(moveToNext()){
                    val _id=getInt(getColumnIndex("id"))
                    val name=getString(getColumnIndex("name"))
                    val phone=getString(getColumnIndex("phone"))
                    Log.e("felix","$_id $name $phone")
                }
                close()
            }
        }
    }
}