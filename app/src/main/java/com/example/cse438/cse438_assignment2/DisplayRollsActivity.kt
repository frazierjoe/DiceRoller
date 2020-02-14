package com.example.cse438.cse438_assignment2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.rolls_activity.*




class DisplayRollsActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rolls_activity)
        var rolls: Rolls = intent.getParcelableExtra(EXTRA_ROLLS) //Grab rolls object
        max_value.text = rolls.maxVal.toString() //Get max value and number of dice
        num_dice.text = rolls.numDice.toString()
        rollDice(rolls) //Roll the dice
        updateValue(rolls)

    }

    fun updateValue(rolls: Rolls){ //Update value after a roll and set the text color accordingly
        var total = rolls.getLastRollTotalList()
        if (total < rolls.getRedRange()) { //Poor Roll
            dice_value.setTextColor(getResources().getColor(R.color.colorRed))
        }
        else if (total > rolls.getGreenRange()){ //Good Roll
            dice_value.setTextColor(getResources().getColor(R.color.colorGreen))
        }
        else { //Avg roll
            dice_value.setTextColor(getResources().getColor(R.color.colorBlack))
        }
        dice_value.text = total.toString()
    }

    fun rollDice(rolls: Rolls){ //Randomly chooses values between 1 and the max value
        var rollTotal=0
        for (x in 1..rolls.numDice){
            var randomNumber = (1..rolls.maxVal).random()
            rolls.rollList.add(randomNumber)
            rollTotal+=randomNumber
        }
        rolls.rollTotalList.add(rollTotal) //Add Values to rolls object
    }

    fun reroll(view: View){ //On reroll, call roll function and update text value and color
        var rolls: Rolls = intent.getParcelableExtra(EXTRA_ROLLS)
        rollDice(rolls)
        updateValue(rolls)
    }


    fun homeClicked(view: View){ //Return to main activity
        var rolls: Rolls = intent.getParcelableExtra(EXTRA_ROLLS)
        val intent = Intent(this, MainActivity::class.java).apply{
            intent.putExtra(EXTRA_ROLLS, rolls)
        }
        startActivity(intent)
    }

    fun seeResultsClicked(view: View){ //Start result activity
        var rolls: Rolls = intent.getParcelableExtra(EXTRA_ROLLS)
        val intent = Intent(this, ResultActivity::class.java).apply{
            putExtra(EXTRA_ROLLS, rolls)
        }
        startActivity(intent)
    }
    fun seeGraphClicked(view: View) { //Start graph activity
        var rolls: Rolls = intent.getParcelableExtra(EXTRA_ROLLS)
        val intent = Intent(this, GraphActivity::class.java).apply {
            putExtra(EXTRA_ROLLS, rolls)
        }
        startActivity(intent)
    }
}
