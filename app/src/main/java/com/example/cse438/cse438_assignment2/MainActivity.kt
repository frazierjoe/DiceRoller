package com.example.cse438.cse438_assignment2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*



const val EXTRA_ROLLS = "com.example.cse438_assignment2.ROLLS"
class MainActivity : AppCompatActivity() {
    var rollList = mutableListOf<Int>()
    var rolls = Rolls(rollList, rollList, 0, 0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(intent.hasExtra(EXTRA_ROLLS)) { //Get the rolls object if it exists
            rolls = intent.getParcelableExtra(EXTRA_ROLLS)
        }
    }

    fun rollClicked(view: View){
        //Validate input
        val inputNumDice = findViewById<EditText>(R.id.input_num_dice)
        val numDice = inputNumDice.text.toString()
        val inputMaxVal = findViewById<EditText>(R.id.input_max_dice_value)
        val maxVal = inputMaxVal.text.toString()
        if(numDice == "" || numDice=="0" || maxVal=="0" || maxVal == ""){
            val toast = Toast.makeText(applicationContext, R.string.roll_btn_error, Toast.LENGTH_LONG)
            toast.show()
        }
        // If the input is valid start the display rolls activity
        else{
            rolls.maxVal = maxVal.toInt()
            rolls.numDice = numDice.toInt()

           val intent = Intent(this, DisplayRollsActivity::class.java).apply{
               putExtra(EXTRA_ROLLS, rolls)
           }
            startActivity(intent)
        }
    }
    fun clearClicked(view: View){
        // Clear rolls data
        Toast.makeText(applicationContext, R.string.clearClickedMessage, Toast.LENGTH_LONG).show()
        input_num_dice.text.clear()
        input_max_dice_value.text.clear()
        rollList = mutableListOf()
        rolls = Rolls(rollList, rollList, 0, 0)
    }
}
