package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class MainActivity : AppCompatActivity() {

    private lateinit var output:TextView
    private lateinit var inputfield:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Intializing Numeric buttons
        val btn00:Button=findViewById(R.id.btn00)
        val btn0:Button=findViewById(R.id.btn0)
        val btn1:Button=findViewById(R.id.btn1)
        val btn2:Button=findViewById(R.id.btn2)
        val btn3:Button=findViewById(R.id.btn3)
        val btn4:Button=findViewById(R.id.btn4)
        val btn5:Button=findViewById(R.id.btn5)
        val btn6:Button=findViewById(R.id.btn6)
        val btn7:Button=findViewById(R.id.btn7)
        val btn8:Button=findViewById(R.id.btn8)
        val btn9:Button=findViewById(R.id.btn9)

        val btn_dot:Button=findViewById(R.id.btn_dot)

        //Intalizing operators
        val btn_CE:Button=findViewById(R.id.btn_CE)
        val leftb:Button=findViewById(R.id.leftb)
        val rightb:Button=findViewById(R.id.rightb)
        val btn_divide:Button=findViewById(R.id.btn_divide)
        val btn_multiply:Button=findViewById(R.id.btn_multiply)
        val btn_add:Button=findViewById(R.id.btn_add)
        val btn_minus:Button=findViewById(R.id.btn_minus)
        val btn_equal:Button=findViewById(R.id.btn_equal)
        output=findViewById(R.id.output)
        inputfield=findViewById(R.id.inputfield)

        //adding Clicklisteners on number buttons
        btn00.setOnClickListener{appendOnClick(true,"00")}
        btn0.setOnClickListener{appendOnClick(true,"0")}
        btn1.setOnClickListener{appendOnClick(true,"1")}
        btn2.setOnClickListener{appendOnClick(true,"2")}
        btn3.setOnClickListener{appendOnClick(true,"3")}
        btn4.setOnClickListener{appendOnClick(true,"4")}
        btn5.setOnClickListener{appendOnClick(true,"5")}
        btn6.setOnClickListener{appendOnClick(true,"6")}
        btn7.setOnClickListener{appendOnClick(true,"7")}
        btn8.setOnClickListener{appendOnClick(true,"8")}
        btn9.setOnClickListener{appendOnClick(true,"9")}

        //adding clicklistener on operator buttons
        btn_dot.setOnClickListener{appendOnClick(false,".")}
        leftb.setOnClickListener{appendOnClick(false,"(")}
        rightb.setOnClickListener{appendOnClick(false,")")}
        btn_divide.setOnClickListener{appendOnClick(false,"/")}
        btn_multiply.setOnClickListener{appendOnClick(false,"*")}
        btn_add.setOnClickListener{appendOnClick(false,"+")}
        btn_minus.setOnClickListener{appendOnClick(false,"-")}
        btn_equal.setOnClickListener{
            calculate()
        }
        btn_CE.setOnClickListener{
            clear()
        }

    }
    private  fun  appendOnClick(clear:Boolean,string:String){
        if(clear){
            output.text=""
            inputfield.append(string)
        }else{
            inputfield.append(output.text)
            inputfield.append(string)
            output.text=""
        }
    }
    private fun clear(){
        inputfield.text=""
        output.text=""
    }
    private fun calculate(){
        try {
            val input=ExpressionBuilder(inputfield.text.toString()).build()
            val outputValue=input.evaluate()
            val longOutput=outputValue.toLong()
            if(outputValue==longOutput.toDouble()){
                output.text=longOutput.toString()
            }else{
                output.text=outputValue.toString()
            }

        }catch (e:Exception){
            Toast.makeText(this,e.message,Toast.LENGTH_LONG).show()
        }
    }

}