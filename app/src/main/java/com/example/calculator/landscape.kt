package com.example.calculator

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.text.Editable
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import net.objecthunter.exp4j.ExpressionBuilder
import net.objecthunter.exp4j.function.Function
import kotlin.math.acos
import kotlin.math.asin
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.tan

class landscape : AppCompatActivity() {

    private var isdegree = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
        setContentView(R.layout.activity_landscape)
        val mainscreen = findViewById<TextView>(R.id.calculation)
        val c = findViewById<Button>(R.id.c)
        val precent = findViewById<Button>(R.id.percent)
        val delete = findViewById<Button>(R.id.delete)
        val divide = findViewById<Button>(R.id.divide)
        val seven = findViewById<Button>(R.id.seven)
        val eight = findViewById<Button>(R.id.eight)
        val nine = findViewById<Button>(R.id.nine)
        val multiply = findViewById<Button>(R.id.multiply)
        val four = findViewById<Button>(R.id.four)
        val five = findViewById<Button>(R.id.five)
        val six = findViewById<Button>(R.id.six)
        val plus = findViewById<Button>(R.id.plus)
        val one = findViewById<Button>(R.id.one)
        val two = findViewById<Button>(R.id.two)
        val three = findViewById<Button>(R.id.three)
        val minus = findViewById<Button>(R.id.minus)
        val zero = findViewById<Button>(R.id.zero)
        val decimal = findViewById<Button>(R.id.decimal)
        val equal = findViewById<Button>(R.id.equal)
      val sin = findViewById<Button>(R.id.sin)
        val rad =  findViewById<Button>(R.id.rad)
        val deg = findViewById<Button>(R.id.deg)
        val cos = findViewById<Button>(R.id.cos)
        val tan = findViewById<Button>(R.id.tan)
        val sininv = findViewById<Button>(R.id.inv)
        val log = findViewById<Button>(R.id.log)
        val ln = findViewById<Button>(R.id.ln)
        val  cosinv = findViewById<Button>(R.id.factorial)
        val pi = findViewById<Button>(R.id.pie)
        val e = findViewById<Button>(R.id.e)
        val power = findViewById<Button>(R.id.power)
        val underroot = findViewById<Button>(R.id.underroot)
        val left = findViewById<Button>(R.id.leftbracket)
        val right = findViewById<Button>(R.id.rightbracket)
        val landscape = findViewById<Button>(R.id.doublezero)






        mainscreen.setHorizontallyScrolling(true)
        mainscreen.isSelected = true

        c.setOnClickListener {
            mainscreen.text = ""
        }
        precent.setOnClickListener {
            mainscreen.text = (mainscreen.text.toString() + "%")
        }
        delete.setOnClickListener {
            val currentText = mainscreen.text.toString()
            if (currentText.isNotEmpty()) {
                mainscreen.text = currentText.dropLast(1)
            }

        }
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        delete.setOnLongClickListener {
            mainscreen.text = ""
            true



            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                vibrator.vibrate(100)
            }

            // Do something else on long click, if needed
            true  // return true to indicate the event was handled


        }
        deg.setOnClickListener {
            isdegree = true
            deg.setTextColor(getColor(R.color.green))
            rad.setTextColor(getColor(R.color.shitelavi))
        }

        rad.setOnClickListener {
            isdegree = false
            rad.setTextColor(getColor(R.color.green))
            deg.setTextColor(getColor(R.color.shitelavi))
        }
        divide.setOnClickListener {
            mainscreen.text = (mainscreen.text.toString() + "÷")
        }
        seven.setOnClickListener {
            mainscreen.text = (mainscreen.text.toString() + "7")
        }
        eight.setOnClickListener {
            mainscreen.text = (mainscreen.text.toString() + "8")
        }
        nine.setOnClickListener {
            mainscreen.append("9")
        }
        multiply.setOnClickListener {
            mainscreen.text = (mainscreen.text.toString() + "×")
        }
        four.setOnClickListener {
            mainscreen.text = (mainscreen.text.toString() + "4")
        }
        five.setOnClickListener {
            mainscreen.text = (mainscreen.text.toString() + "5")
        }
        six.setOnClickListener {
            mainscreen.text = (mainscreen.text.toString() + "6")
        }
        plus.setOnClickListener {
            mainscreen.text = (mainscreen.text.toString() + "+")
        }
        one.setOnClickListener {
            mainscreen.text = (mainscreen.text.toString() + "1")
        }
        two.setOnClickListener {
            mainscreen.text = (mainscreen.text.toString() + "2")
        }
        three.setOnClickListener {
            mainscreen.text = (mainscreen.text.toString() + "3")
        }
        minus.setOnClickListener {
            mainscreen.text = (mainscreen.text.toString() + "-")
        }
        landscape.setOnClickListener {
        val lavish = Intent(this , MainActivity::class.java)
            startActivity(lavish)
        }
        zero.setOnClickListener {
            mainscreen.text = (mainscreen.text.toString() + "0")
        }
        decimal.setOnClickListener {
            mainscreen.text = (mainscreen.text.toString() + ".")
        }
        sin.setOnClickListener {
            mainscreen.append(if (isdegree) "sinDeg" else "sin")
        }

        cos.setOnClickListener {
            mainscreen.append(if (isdegree) "cosDeg" else "cos")
        }

        tan.setOnClickListener {
            mainscreen.append(if (isdegree) "tanDeg" else "tan")
        }
        log.setOnClickListener {
            mainscreen.text = mainscreen.text.toString() + "log"
        }
        ln.setOnClickListener {
            mainscreen.text = mainscreen.text.toString() + "ln"
        }
        power.setOnClickListener {
            mainscreen.text = mainscreen.text.toString() + "^"
        }
        pi.setOnClickListener {
            mainscreen.text = mainscreen.text.toString() + "π"
        }
        e.setOnClickListener {
            mainscreen.text = mainscreen.text.toString() +"e"
        }
        underroot.setOnClickListener {
            mainscreen.text = mainscreen.text.toString() +"√"
        }
        left.setOnClickListener {
            mainscreen.text = mainscreen.text.toString() +"("
        }
        right.setOnClickListener {
            mainscreen.text = mainscreen.text.toString() +")"
        }
        cosinv.setOnClickListener {
            mainscreen.text = mainscreen.text.toString() + "cos⁻¹"
        }
        sininv.setOnClickListener {
            mainscreen.text = mainscreen.text.toString() + "sin⁻¹"
        }



        equal.setOnClickListener {
            val input = mainscreen.text.toString()
                .replace("÷", "/")
                .replace("×", "*")
                .replace(Regex("(\\d+(?:\\.\\d+)?)!")) { matchResult ->
                    val number = matchResult.groupValues[1]
                    "fact($number)"
                }
                .replace(Regex("√(\\d+(?:\\.\\d+)?)")) { matchResult ->
                    val number = matchResult.groupValues[1]
                    "sqrt($number)"
                }
                .replace("sin⁻¹" , "asin")
                .replace("cos⁻¹" , "acos")

            if (mainscreen.text == "2025"){
                equal.setOnClickListener {
                    val lavish = Intent (this , lavish::class.java)
                    startActivity(lavish)
                }
            }




            try {
                val result = evaluateexpression(input)
                val resultText = if (result == result.toLong().toDouble()) {
                    result.toLong().toString()
                } else {
                    result.toString()
                }
                mainscreen.text =
                    Editable.Factory.getInstance().newEditable(resultText.toString())
            } catch (e: Exception) {
                mainscreen.setText("Error: ${e.message}")
            }
        }










        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }

    }




}

val sinDeg = object : Function("sinDeg", 1) {
    override fun apply(vararg args: Double): Double = sin(Math.toRadians(args[0]))
}

val cosDeg = object : Function("cosDeg", 1) {
    override fun apply(vararg args: Double): Double = cos(Math.toRadians(args[0]))
}

val tanDeg = object : Function("tanDeg", 1) {
    override fun apply(vararg args: Double): Double = tan(Math.toRadians(args[0]))
}
var asin: Function = object : Function("asin", 1) {
    override fun apply(vararg args: Double): Double {
        return asin(args[0])
    }
}
var acos : Function = object :Function("acos", 1) {
    override fun apply(vararg args: Double): Double {
        return acos(args[0])
    }
}
val ln = object : Function("ln", 1) {
    override fun apply(vararg args: Double): Double = kotlin.math.ln(args[0])
}


fun evaluateexpression(expression: String): Double {
    return ExpressionBuilder(expression)
        .function(sinDeg)
        .function(cosDeg)
        .function(tanDeg)
        .function(asin)
        .function(acos)
        .function(ln)
        .build()
        .evaluate()


}

