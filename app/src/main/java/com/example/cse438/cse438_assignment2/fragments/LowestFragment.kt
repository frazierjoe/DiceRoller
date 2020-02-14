package com.example.cse438.cse438_assignment2.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.example.cse438.cse438_assignment2.EXTRA_ROLLS

import com.example.cse438.cse438_assignment2.R
import com.example.cse438.cse438_assignment2.Rolls
import kotlinx.android.synthetic.main.fragment_lowest.*

class LowestFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lowest, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var rolls = arguments!!.getParcelable<Rolls>(EXTRA_ROLLS)
        lowRoll.text = rolls.getMin().toString()
        //Create on click listener and switch fragments if clicked
        LowToAvgBtn.setOnClickListener{
            val fragment = AverageFragment()
            var bundle = Bundle()
            bundle.putParcelable(EXTRA_ROLLS, rolls)
            fragment.arguments = bundle
            val transaction = activity!!.supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frag_container, fragment)
            transaction.commit()
        }
        //Create on click listener and switch fragments if clicked
        LowToHighBtn.setOnClickListener{
            val fragment = HighestFragment()
            var bundle = Bundle()
            bundle.putParcelable(EXTRA_ROLLS, rolls)
            fragment.arguments = bundle
            val transaction = activity!!.supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frag_container, fragment)
            transaction.commit()
        }

    }

}
