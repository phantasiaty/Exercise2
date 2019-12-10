package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.lang.Math.pow
import java.time.OffsetTime
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fun calculateBMI(weight:Double, height:Double):Double{
            return weight / (height*height)
        }
        buttonCalculate.setOnClickListener {
           val weight:Double = editTextWeight.text.toString().toDouble()
           val height:Double = editTextHeight.text.toString().toDouble()
           val bmi:Double = calculateBMI(weight,height/100)
           val status:String
           try {
               when {
                   bmi < 18.5 -> {
                       imageViewProfile.setImageResource(R.drawable.under)
                       status = "Under Weight"
                   }
                   bmi < 25 -> {
                       imageViewProfile.setImageResource(R.drawable.normal)
                       status = "Normal Weight"
                   }
                   else -> {
                       imageViewProfile.setImageResource(R.drawable.over)
                       status = "Over Weight"
                   }
               }
               textViewBMI.setText("BMI %.2f (%S)".format(bmi, status))


           }catch (ex:Exception){
               val toast:Toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG)
               toast.setGravity(Gravity.CENTER, 0, 0)
               toast.show()
           }
        }
        buttonReset.setOnClickListener {
            editTextHeight.text = null
            editTextWeight.text = null
            textViewBMI.text = "BMI:"
            imageViewProfile.setImageResource(R.drawable.empty)
        }
    }
}


