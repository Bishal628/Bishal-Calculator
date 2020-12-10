package com.bishal.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {


    private lateinit var tvDivide: TextView
    private lateinit var tvMultiply: TextView
    private lateinit var tvSubtract: TextView
    private lateinit var tvAdd: TextView
    private lateinit var tvOpen: TextView
    private lateinit var tvClose: TextView
    private lateinit var tvOne: TextView
    private lateinit var tvTwo: TextView
    private lateinit var tvThree: TextView
    private lateinit var tvFour: TextView
    private lateinit var tvFive: TextView
    private lateinit var tvSix: TextView
    private lateinit var tvSeven: TextView
    private lateinit var tvEight: TextView
    private lateinit var tvNine: TextView
    private lateinit var tvZero: TextView
    private lateinit var tvDot: TextView
    private lateinit var tvExpression: TextView
    private lateinit var tvResult: TextView
    private lateinit var tvClear: TextView
    private lateinit var tvBackspace: TextView
    private lateinit var tvEquals: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tvResult)
        tvExpression = findViewById(R.id.tvExpression)
        tvEquals = findViewById(R.id.tvEquals)
        tvClear = findViewById(R.id.tvClear)
        tvBackspace = findViewById(R.id.tvBackspace)
        tvDivide = findViewById(R.id.tvDivide)
        tvMultiply = findViewById(R.id.tvMultiply)
        tvSubtract = findViewById(R.id.tvSubtract)
        tvAdd = findViewById(R.id.tvAdd)
        tvOpen = findViewById(R.id.tvOpen)
        tvClose = findViewById(R.id.tvClose)
        tvOne = findViewById(R.id.tvOne)
        tvTwo = findViewById(R.id.tvTwo)
        tvThree = findViewById(R.id.tvThree)
        tvFour = findViewById(R.id.tvFour)
        tvFive = findViewById(R.id.tvFive)
        tvSix = findViewById(R.id.tvSix)
        tvSeven = findViewById(R.id.tvSeven)
        tvEight = findViewById(R.id.tvEight)
        tvNine = findViewById(R.id.tvNine)
        tvZero = findViewById(R.id.tvZero)
        tvDot = findViewById(R.id.tvDot)


        tvOne.setOnClickListener { appendOnExpression("1", true) }
        tvTwo.setOnClickListener { appendOnExpression("2", true) }
        tvThree.setOnClickListener {appendOnExpression("3", true) }
        tvFour.setOnClickListener {appendOnExpression("4", true) }
        tvFive.setOnClickListener {appendOnExpression("5", true) }
        tvSix.setOnClickListener {appendOnExpression("6", true) }
        tvSeven.setOnClickListener { appendOnExpression("7", true)}
        tvEight.setOnClickListener {appendOnExpression("8", true) }
        tvNine.setOnClickListener { appendOnExpression("9", true)}
        tvZero.setOnClickListener {appendOnExpression("0", true) }
        tvDot.setOnClickListener {appendOnExpression(".", true) }
        tvDivide.setOnClickListener {appendOnExpression("/", false) }
        tvMultiply.setOnClickListener {appendOnExpression("*", false)  }
        tvSubtract.setOnClickListener {appendOnExpression("-", false)  }
        tvAdd.setOnClickListener {appendOnExpression("+", false)  }
        tvOpen.setOnClickListener {appendOnExpression("(", false)  }
        tvClose.setOnClickListener {appendOnExpression(")", false)  }

        tvClear.setOnClickListener {
            tvExpression.text=""
            tvResult.text=""
        }

        tvBackspace.setOnClickListener {
            val Value = tvExpression.text.toString()
            if (Value.isNotEmpty()){
                tvExpression.text=Value.substring(0, Value.length-1)
            }
            tvResult.text=""
        }

        tvEquals.setOnClickListener {
            try {

                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result == longResult.toDouble())
                    tvResult.text = longResult.toString()
                else
                    tvResult.text = result.toString()

            }catch (e:Exception){
                Log.d("Exception"," message : " + e.message )
            }
        }
    }

    fun appendOnExpression(string:String, Clear:Boolean){
        if (tvResult.text.isNotEmpty()){
            tvExpression.text =""
        }
        if (Clear){
            tvResult.text=""
            tvExpression.append(string)
        }
        else{
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text=""
        }
    }
}