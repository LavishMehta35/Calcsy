package com.example.calculator

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.jvm.java


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
      


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val mainscreen = findViewById<TextView>(R.id.calculation)
        val c = findViewById<Button>(R.id.sin)
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
        val heart = findViewById<Button>(R.id.heart)
        val zero = findViewById<Button>(R.id.zero)
        val decimal = findViewById<Button>(R.id.decimal)
        val equal = findViewById<Button>(R.id.equal)


        mainscreen.movementMethod = android.text.method.ScrollingMovementMethod()
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
            heart.setOnClickListener {
                val intent = Intent(this, landscape::class.java)
                startActivity(intent)
            }
            zero.setOnClickListener {
                mainscreen.text = (mainscreen.text.toString() + "0")
            }
            decimal.setOnClickListener {
                mainscreen.text = (mainscreen.text.toString() + ".")
            }
            equal.setOnClickListener {
                val input = mainscreen.text.toString().replace("÷", "/" )
                    .replace("×" ,"*")

                if (mainscreen.text == "2025"){
                    val lavish = Intent (this, lavish::class.java)
                    startActivity(lavish)
                }


                try {
                    val result = evaluateExpression(input)
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



    fun evaluateExpression(expression: String): Double {
        return ExpressionBuilder(expression).build().evaluate()
    }
