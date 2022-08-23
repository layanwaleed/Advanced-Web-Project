package com.example.project

import android.content.Context
import android.content.pm.PackageManager
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.sql.SQLException
import android.content.Intent as Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btn: Button = findViewById(R.id.button)
        val btn2:Button=findViewById(R.id.button4)

        val txt: TextView = findViewById(R.id.txt)
        val menuIntent: Intent = Intent(this, Menu::class.java)
        btn.setOnClickListener() {
            Toast.makeText(this, "You Are About To See my beautiful Menu", Toast.LENGTH_SHORT)
                .show()
            val intent =Intent(this,Menu::class.java)
            startActivity(intent)
        }
        btn2.setOnClickListener(){
            val intent3 =Intent(this,UserInfo::class.java)
            startActivity(intent3)
        }


    }

    //menu code
    override fun onCreateOptionsMenu(menu: android.view.Menu?): Boolean {
        val inflater=menuInflater
        inflater.inflate(R.menu.mymenu,menu)
        return super.onCreateOptionsMenu(menu)

    }

    //this code is to go to another activity when the menu options are clicked
    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        when(item.itemId){
            R.id.Userprofile->{
                this.startActivity(Intent(this,userprofile::class.java))
                return true;
            }
            //  else->super.onOptionsItemSelected(item)
            R.id.Aboutus->{
                this.startActivity(Intent(this,Aboutus::class.java))
                return true;
            }

        }
        return true;
    }
}

