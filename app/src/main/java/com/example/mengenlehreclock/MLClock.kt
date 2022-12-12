package com.example.mengenlehreclock


import com.example.mengenlehreclock.model.ClockColor
import com.example.mengenlehreclock.model.ClockData
import com.example.mengenlehreclock.model.ClockData.Companion.OUT
import com.example.mengenlehreclock.model.ClockData.Companion.RED
import com.example.mengenlehreclock.model.ClockData.Companion.YELLOW
import kotlin.math.floor

class MLClock {

    fun getMLClock(time: String): ClockData {
        val timeParts =  time.split(":") //TODO: hardcoded, make a const
        val hours: Int = handleTheAmericans1(timeParts)
        println(hours)
        val fiveHourRow = getFiveHourRow(hours)
        val lastHourRow = getLastHourRow(hours)
        val fiftyFiveMinuteRow = getFiftyFiveMinuteRow(timeParts[1].toInt())
        val lastFiveMinuteRow = getLastFiveMinutes(timeParts[1].toInt()) //TODO: add things like timeParts to a key value map so you never make mistakes
        val secondsCircle = getSecondsCircle(handleTheAmericans2(timeParts))

        return ClockData(fiveHourRow = fiveHourRow,
            lastHourRow = lastHourRow,
            fiftyFiveMinuteRow = fiftyFiveMinuteRow,
            lastMinuteRow = lastFiveMinuteRow,
            secondsCircle = secondsCircle)
    }

    //TODO: this is ugly and hard to read, refactor 1 and 2
    private fun handleTheAmericans1(timeParts : List<String>) : Int{
        return if (timeParts[2].contains("PM"))  {//TODO: hardcoded, make a const
            if (timeParts[0].contains("12")) {//TODO: hardcoded, make a const
                timeParts[0].toInt()
            } else {
                val hours = timeParts[0].toInt()
                hours + 12
            }

        } else {
            if (timeParts[2].contains("AM") && timeParts[0].contains("12")) {//TODO: hardcoded, make a const
                0 //12 am edge case, instead of + 12 we want 00 as in 24hourformat
            } else {
                timeParts[0].toInt()
            }
        }
    }

    private fun handleTheAmericans2(timeParts : List<String>) : Int{
        return if (timeParts[2].length > 3)  { //TODO: hardcoded, make a const
            timeParts[2].substring(0,2).toInt()
        } else timeParts[2].toInt()
    }

    private fun getSecondsCircle(seconds: Int) : ClockColor {
        return if (seconds % 2 == 0) {
            YELLOW
        } else {
            OUT
        }
    }


    private fun getLastHourRow(hours : Int): List<ClockColor> {
        return when( hours % 5) {
            0 -> listOf(OUT, OUT, OUT, OUT)
            1 -> listOf(RED, OUT, OUT, OUT)
            2 -> listOf(RED, RED, OUT, OUT)
            3 -> listOf(RED, RED, RED, OUT)
            4 -> listOf(RED, RED, RED, RED)
            else -> emptyList()
            //TODO: else should throw an error in case we missed something
        }
    }

    private fun getFiveHourRow(hours : Int): List<ClockColor> {
        return when(floor(hours.toDouble() / 5.0)) {
            0.0 -> listOf(OUT, OUT, OUT, OUT)
            1.0 -> listOf(RED, OUT, OUT, OUT)
            2.0 -> listOf(RED, RED, OUT, OUT)
            3.0 -> listOf(RED, RED, RED, OUT)
            4.0 -> listOf(RED, RED, RED, RED)
            else -> emptyList()
        }
    }

    private fun getFiftyFiveMinuteRow(minutes : Int): List<ClockColor> {
        return when(floor(minutes.toDouble() / 5.0)) {
            0.0 -> listOf(OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT)
            1.0 -> listOf(YELLOW, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT)
            2.0 -> listOf(YELLOW, YELLOW, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT)
            3.0 -> listOf(YELLOW, YELLOW, RED, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT)
            4.0 -> listOf(YELLOW, YELLOW, RED, YELLOW, OUT, OUT, OUT, OUT, OUT, OUT, OUT)
            5.0 -> listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, OUT, OUT, OUT, OUT, OUT, OUT)
            6.0 -> listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, OUT, OUT, OUT, OUT, OUT)
            7.0 -> listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, OUT, OUT, OUT, OUT)
            8.0 -> listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, YELLOW, OUT, OUT, OUT)
            9.0 -> listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, OUT, OUT)
            10.0 -> listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, OUT)
            11.0 -> listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, YELLOW)
            else -> emptyList()
        }
    }

    private fun getLastFiveMinutes(minutes : Int): List<ClockColor> {
        return when(minutes % 5) {
            0 -> listOf(OUT, OUT, OUT, OUT)
            1 -> listOf(YELLOW, OUT, OUT, OUT)
            2 -> listOf(YELLOW, YELLOW, OUT, OUT)
            3 -> listOf(YELLOW, YELLOW, YELLOW, OUT)
            4 -> listOf(YELLOW, YELLOW, YELLOW, YELLOW)
            else -> emptyList()
        }
    }
}