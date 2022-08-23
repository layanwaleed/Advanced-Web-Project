package com.example.project

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.sql.SQLException

class UserInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userinfo)

       //this button is for inserting values also
        val btn: Button = findViewById(R.id.button5)
        //update
        val updatebtn:Button=findViewById(R.id.updatevaluesbtn)
        //delete
        val deletebtn:Button=findViewById(R.id.deletevaluesbtn)

        val fnametxt:EditText=findViewById(R.id.editTextTextPersonName)
        val snametxt:EditText=findViewById(R.id.editTextTextPersonName2)
        val emailtxt:EditText=findViewById(R.id.editTextTextEmailAddress)
        val passtxt:EditText=findViewById(R.id.editTextTextPassword)
        val phonetxt:EditText=findViewById(R.id.editTextPhone)
        val addresstxt:EditText=findViewById(R.id.editTextTextMultiLine2)


        // create instance of SQLiteDatabase
        var cusdb:SQLiteDatabase?=null
        try {
            cusdb = openOrCreateDatabase("mydatabase", Context.MODE_PRIVATE, null)
            cusdb.execSQL("Create Table Customers(id Integer PRIMARY KEY, name Text)")
            cusdb.close()
        }
        catch (e:SQLException)
        {
            e.stackTraceToString()
        }


        btn.setOnClickListener{

            //we will insert values once we click on this button,then go to new activity
            val values = ContentValues()
            values.put("fisrtname", fnametxt.text.toString())
            values.put("secondname", snametxt.text.toString())
            values.put("email", emailtxt.text.toString())
            values.put("password", passtxt.text.toString().toInt())
            values.put("phonenumber", phonetxt.text.toString().toInt())
            values.put("address", addresstxt.text.toString())

            try {

                val res:Long? = cusdb?.insert("mydatabase", null, values)
                Toast.makeText(this, "the result"+res.toString(), Toast.LENGTH_SHORT).show()
            }
            catch (ex:Exception)
            {
                Toast.makeText(this, "Error\n"+ex.message+ex.printStackTrace(), Toast.LENGTH_SHORT).show()
                //ex.message + ex.printStackTrace()
            }
            cusdb?.close()



            Toast.makeText(this, "Let's see what's in The menu now!", Toast.LENGTH_SHORT)
                .show()

            val intent6 = Intent(this, Menu::class.java)
            startActivity(intent6)

        }
        //delete a record from a table
        deletebtn.setOnClickListener{

            cusdb?.delete("Customers", null, arrayOf("Firstname==Ali"))
            cusdb?.close()
        }


        // updating table contents by sending a bundle
        updatebtn.setOnClickListener{
            val customerBundle = Bundle()
            val customerIntent = Intent(this, Menu::class.java)

            customerBundle.putString("firstname", fnametxt.text.toString())
            customerBundle.putString("secondname", snametxt.text.toString())
            customerBundle.putString("email", emailtxt.text.toString())

            customerIntent.putExtras(customerBundle)

            if (customerIntent.resolveActivity(getPackageManager()) != null)
                startActivity(customerIntent)

        }

        // showing all table contents
        val showcontentbtn:Button=findViewById(R.id.showbtn)

        showcontentbtn.setOnClickListener{
            val c: Cursor? = cusdb?.rawQuery("SELECT * FROM Customers", null)
            c?.moveToFirst()
            while (c?.isAfterLast() == false) {
                Toast.makeText(
                    this,
                    c?.getString(0) + " " + c.getString(1), Toast.LENGTH_LONG
                ).show()
                c?.moveToNext()
            }

            c?.close()
            cusdb?.close()



        }


    }
}
