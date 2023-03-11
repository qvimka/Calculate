package com.example.calculate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.calculate.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.butClear.setOnClickListener {
            binding.input.text =""
            binding.output.text = ""
        }  //обнуление значений

        binding.butBrackerLeft.setOnClickListener {
            binding.input.text = addToInputText("(")
        }

       binding.butBrackerRight.setOnClickListener {
            binding.input.text = addToInputText(")")
        }

        binding.but0.setOnClickListener {
            binding.input.text = addToInputText("0")
        }

        binding.but1.setOnClickListener {
            binding.input.text = addToInputText("1")
        }
        binding.but2.setOnClickListener {
            binding.input.text = addToInputText("2")
        }

        binding.but3.setOnClickListener {
            binding.input.text = addToInputText("3")
        }
        binding.but4.setOnClickListener {
            binding.input.text = addToInputText("4")
        }

        binding.but5.setOnClickListener {
            binding.input.text = addToInputText("5")
        }
        binding.but6.setOnClickListener {
            binding.input.text = addToInputText("6")
        }

        binding.but7.setOnClickListener {
            binding.input.text = addToInputText("7")
        }
        binding.but8.setOnClickListener {
            binding.input.text = addToInputText("8")
        }

        binding.but9.setOnClickListener {
            binding.input.text = addToInputText("9")
        }

        binding.butTochka.setOnClickListener {
            binding.input.text = addToInputText(".")
        }
        binding.butPlus.setOnClickListener {
            binding.input.text = addToInputText("+")
        }
        binding.butDelenie.setOnClickListener {
            binding.input.text = addToInputText("/")
        }
        binding.butYmnojenie.setOnClickListener {
            binding.input.text = addToInputText("*")
        }
        binding.butMinus.setOnClickListener {
            binding.input.text = addToInputText("-")
        }

        binding.butRavno.setOnClickListener {
          showRes()
      } // показ результатов

    }

    private fun addToInputText(buttonValues:String):String{
        return "${binding.input.text}$buttonValues"
    }

    private fun getInputExpr():String{
        var Expr = binding.input.text.replace(Regex("÷"), "/")
        Expr = Expr.replace(Regex("×"), "*")
        return Expr
    }

    private fun showRes(){
        try {
            val Expr = getInputExpr()
            val result = Expression(Expr).calculate()
            if (result.isNaN()){
                binding.output.text = "Erros"
                binding.output.setTextColor(ContextCompat.getColor(this,R.color.purple_500))
            }else{
                binding.output.text = DecimalFormat("0.#####").format(result).toString()
                binding.output.setTextColor(ContextCompat.getColor(this,R.color.teal_200))
            }
        } catch (e: Exception){
            binding.output.text = "Erros"
            binding.output.setTextColor(ContextCompat.getColor(this,R.color.purple_500))
        }
    }
}