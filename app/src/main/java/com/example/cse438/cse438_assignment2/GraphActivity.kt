package com.example.cse438.cse438_assignment2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.BarGraphSeries
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import kotlinx.android.synthetic.main.graph_activity.*

class GraphActivity : AppCompatActivity() {
    var rollList = mutableListOf<Int>()
    var rolls = Rolls(rollList, rollList, 0, 0)
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.graph_activity)
        rolls = intent.getParcelableExtra(EXTRA_ROLLS) //Grab rolls object
        createGraph(rolls) //Generate the graph

    }

    fun createGraph(rolls: Rolls) {
        var graph = findViewById<GraphView>(R.id.graph)
        var series = BarGraphSeries<DataPoint>()
        var max = rolls.maxVal
        var sumList = MutableList(max+1) {0.0} //A list containing the number of times each dice value was rolled
        var rollList = rolls.rollList
        var size: Int = rollList.size - 1
        var temp: Int
        for(z in 0..size){ //Loop through rolls and add up the number of times each value was rolled
            temp = rollList[z]
            sumList[temp]+=1.0
        }
        var b: Double
        for(a in 1..max){ //Create data points for each value
            b = a.toDouble()
            series.appendData(DataPoint(b, sumList[a]),true, 1000000000)
        }
        //Graph Options
        series.setSpacing(10)
        series.setValueDependentColor { getResources().getColor(R.color.colorGraph) }
        graph.addSeries(series)
        graph.viewport.setMinX(0.5)
        var maxDouble: Double = max.toDouble()+0.5
        graph.viewport.setMaxX(maxDouble)
        graph.viewport.isScalable = true
        graph.viewport.isScrollable = true
        graph.viewport.backgroundColor=getResources().getColor(R.color.colorSecondary)
    }

    fun cancelClickedGraph(view: View){ //Return to main activity
        val intent = Intent(this, MainActivity::class.java).apply{
            putExtra(EXTRA_ROLLS, rolls)
        }
        startActivity(intent)
    }

}