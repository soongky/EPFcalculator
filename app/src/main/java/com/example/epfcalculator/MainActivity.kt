package com.example.epfcalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var age:Int = 0
        var saving:Double

      pickerbirthday.setOnClickListener() {
          val c: Calendar = Calendar.getInstance()
          val cDay = c.get(Calendar.DAY_OF_MONTH)
          val cMonth = c.get(Calendar.MONTH)
          val cYear = c.get(Calendar.YEAR)

          val dpd =  DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, day ->
                  pickerbirthday.setText(day.toString() + '/' + (month + 1).toString() + '/' + year.toString())
                  age = cYear - year
                  agetxt.text = age.toString()
              }, cYear, cMonth, cDay)
          dpd.show()
      }
          btnCal.setOnClickListener {
              saving =getSavingAmount(age)
                  savingtxt.text = saving.toString()
              transfertxt.text = (saving * 30 / 100).toString()
          }
      }


        fun getSavingAmount(age:Int): Double{
            when(age){
                in 16..20 ->return 5000.00
                in 21..25->return 14000.00
                in 26..30->return 29000.00
                in 31..35->return 50000.00
                in 36..40->return 78000.00
                in 41..45->return 14000.00
                in 46..50->return 14000.00
                in 51..55->return 14000.00
                else->return 0.00
            }


    }
}
