package com.example.cse438.cse438_assignment2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.cse438.cse438_assignment2.fragments.AverageFragment

class ResultActivity : AppCompatActivity() {
    var rollList = mutableListOf<Int>()
    var rolls = Rolls(rollList, rollList, 0, 0)
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_activity)
        rolls = intent.getParcelableExtra(EXTRA_ROLLS) //Grab the rolls object

    }

    override fun onStart() {
        super.onStart()
        val fragment = AverageFragment() //Display the avg fragment by default
        var bundle = Bundle()
        bundle.putParcelable(EXTRA_ROLLS, rolls) //Pass the rolls object to the fragment
        fragment.arguments = bundle
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frag_container, fragment)
        transaction.commit()
    }

    fun cancelClicked(view: View){ //Start main activity
        val intent = Intent(this, MainActivity::class.java).apply{
            putExtra(EXTRA_ROLLS, rolls)
        }
        startActivity(intent)
    }


}