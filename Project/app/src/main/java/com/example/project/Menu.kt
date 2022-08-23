package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*


class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btn2:Button=findViewById(R.id.button2)
        val box1:CheckBox=findViewById(R.id.checkBox)
        val box2:CheckBox=findViewById(R.id.checkBox2)
        val box3:CheckBox=findViewById(R.id.checkBox9)
        val box4:CheckBox=findViewById(R.id.checkBox10)
        val box5:CheckBox=findViewById(R.id.checkBox5)
        val box6:CheckBox=findViewById(R.id.checkBox6)


        btn2.setOnClickListener(){
            if(box2.isChecked){
                Toast.makeText(this, " pizza has been added to basket", Toast.LENGTH_SHORT).show()
            }
            if (box1.isChecked){
                Toast.makeText(this, "burger has been added to basket", Toast.LENGTH_SHORT).show()
            }
            if(box3.isChecked){
                Toast.makeText(this, " potato has been added to basket", Toast.LENGTH_SHORT).show()
            }
            if(box4.isChecked){
                Toast.makeText(this, " salad has been added to basket", Toast.LENGTH_SHORT).show()
            }
            if(box5.isChecked){
                Toast.makeText(this, " iced coffee has been added to basket", Toast.LENGTH_SHORT).show()
            }
            if(box6.isChecked){
                Toast.makeText(this, "desserts has been added to basket", Toast.LENGTH_SHORT).show()
            }
            //total prices

            val total:Int;
            //total=0;
            total= Calculate()+ price1();

            if(box1.isChecked && box2.isChecked){
                Toast.makeText(this,"Your Total price is"+ total+"JD",Toast.LENGTH_SHORT).show();
            }

            val total1:Double;
            total1= price2()+ price3();

            if(box3.isChecked && box4.isChecked){
                Toast.makeText(this,"Your Total price is"+ total1+"JD",Toast.LENGTH_SHORT).show();
            }

            val total2:Double;
            total2= price4()+ price5();

            if(box5.isChecked && box6.isChecked){
                Toast.makeText(this,"Your Total price is"+ total2+"JD",Toast.LENGTH_SHORT).show();
            }

            val total3:Double;
            total3= Calculate()+ price2();
            if(box1.isChecked && box3.isChecked){
                Toast.makeText(this,"Your Total price is"+ total3+"JD",Toast.LENGTH_SHORT).show();
            }

            val total4:Int;
            total4=Calculate()+price3();
            if(box1.isChecked && box4.isChecked){
                Toast.makeText(this,"Your Total price is"+ total4+"JD",Toast.LENGTH_SHORT).show();
            }

            val total5:Double;
            total5= Calculate()+price4();
            if(box1.isChecked && box5.isChecked){
                Toast.makeText(this,"Your Total price is"+ total5+"JD",Toast.LENGTH_SHORT).show();
            }

            val total6:Double;
            total6=Calculate()+ price5();
            if(box1.isChecked && box6.isChecked){
                Toast.makeText(this,"Your Total price is"+ total6+"JD",Toast.LENGTH_SHORT).show();
            }
            

            //prices

            if(box1.isChecked){
                Toast.makeText(this,"burger price is"+ Calculate()+"JD",Toast.LENGTH_SHORT).show();
            }
            if(box2.isChecked){
                Toast.makeText(this,"pizza price is"+ price1()+"JD",Toast.LENGTH_SHORT).show();
            }
            if(box3.isChecked){
                Toast.makeText(this,"potato price is"+ price2() +"JD",Toast.LENGTH_SHORT).show();
            }
            if(box4.isChecked){
                Toast.makeText(this,"Salad price is"+ price3() +"JD",Toast.LENGTH_SHORT).show();
            }
            if(box5.isChecked){
                Toast.makeText(this,"Iced Coffee price is"+ price4() +"JD",Toast.LENGTH_SHORT).show();
            }
            if(box6.isChecked){
                Toast.makeText(this,"Desserts price is"+ price5() +"JD",Toast.LENGTH_SHORT).show();
            }

            val intent1 = Intent(this,Checkout::class.java)
            startActivity(intent1)
        }

    }
}
public fun Calculate():Int{
    return 5;
}
public fun price1():Int{
    return 4;
}
public fun price2():Double{
    return 3.5
}
public fun price3():Int{
    return 2
}
public fun price4():Double{
    return 3.5;
}
public fun price5():Double{
    return 1.5;
}