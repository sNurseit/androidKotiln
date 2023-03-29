package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide();
    }

    fun onClickBut (view: View){
        var weight = findViewById<EditText>(R.id.userWeight).text.toString();
        var height = findViewById<EditText>(R.id.userHeight).text.toString();
        var output = findViewById<TextView>(R.id.Output)
        var back = findViewById<View>(R.id.view)
        var outputPr=  findViewById<TextView>(R.id.outputPredict)

        if (weight.length !=0 && height.length!=0){
            var  w =  weight.toDouble()
            var  h =  height.toDouble()/100
            var ans = w/(h*h);

            if(ans > 18.5){
                ans+=0.5;
            }
            var intAns = ans.toInt()


            when (intAns) {
                in 0..18 -> {
                    back.setBackgroundColor(Color.parseColor("#000AFF"));
                    outputPr.text = "You are underweight!";
                }
                in 18..25 -> {
                    back.setBackgroundColor(Color.parseColor("#42FF00"))
                    outputPr.text = "You are of normal weight.";
                }
                in 25..30 -> {
                    back.setBackgroundColor(Color.parseColor("#FFE600"))
                    outputPr.text = "You are of overweight.";
                }
                in 30..35 -> {
                    back.setBackgroundColor(Color.parseColor("#FF7A00"))
                    outputPr.text = "You are obese";
                }
                in 35..40 -> {
                    back.setBackgroundColor(Color.parseColor("#FF0000"))
                    outputPr.text = "You are obese";
                }
                in 40..100000 -> {
                    back.setBackgroundColor(Color.parseColor("#9F0000"))
                    outputPr.text = "You are obese";
                }
                else -> {

                }
            }

            output.text = ans.toString()
        }

    }
}