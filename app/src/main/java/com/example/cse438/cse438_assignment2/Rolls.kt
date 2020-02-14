package com.example.cse438.cse438_assignment2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Rolls(var rollList: MutableList<Int>, var rollTotalList: MutableList<Int>, var maxVal: Int, var numDice: Int) : Parcelable {

    fun getExpectation(): Double { //Calculates the expected value of the rolls
        var probability : Double = 1/maxVal.toDouble()
        var sum :Double = 0.0
        for (y in 1..numDice) {
            for (x in 1..maxVal) {
                sum += x * probability
            }
        }
        return sum
    }

    fun getGreenRange(): Double{ //Calculates the midpoint between the minimum value and expected value
        var expectation = getExpectation()
        val max = maxVal * numDice
        val greenTextRange: Double = ((max - expectation)/2) + expectation //Midpoint calculation
        return greenTextRange
    }

    fun getRedRange(): Double{ //Calculates the midpoint between the maximum value and the expected value
        var expectation = getExpectation()
        val min = numDice
        val redTextRange : Double = expectation - ((expectation-min)/2)
        return redTextRange
    }

    fun getLastRollTotalList(): Int{ //Returns the last item in the rollTotalList
        val last = rollTotalList.lastIndex
        return rollTotalList[last]
    }

    fun getMax(): Int{ //Returns the maximum value in the rollsTotalList
        var max = 0
        var size = rollTotalList.size - 1
        for(x in 0..size){
            if(rollTotalList[x] > max){
                max = rollTotalList[x]
            }

        }
        return max
    }

    fun getMin(): Int{ //Returns the minimum value in the rollsTotalList
        var size = rollTotalList.size - 1
        var min = rollTotalList[0]
        for(x in 0..size){
            if(rollTotalList[x] < min){
                min = rollTotalList[x]
            }

        }
        return min
    }

    fun getAvg(): Double{ //Returns the avg value in the rollsTotal List
        var avg: Double
        var size = rollTotalList.size
        var sum = 0
        for(x in 0 until size){
            sum += rollTotalList[x]
        }
        avg = sum.toDouble()/size
        return avg
    }
}
