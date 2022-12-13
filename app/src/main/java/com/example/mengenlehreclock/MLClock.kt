package com.example.mengenlehreclock


import com.example.mengenlehreclock.model.ClockColor
import com.example.mengenlehreclock.model.ClockData
import com.example.mengenlehreclock.model.ClockData.Companion.OUT
import com.example.mengenlehreclock.model.ClockData.Companion.RED
import com.example.mengenlehreclock.model.ClockData.Companion.YELLOW
import com.example.mengenlehreclock.utils.TimeUtil.Companion.convert
import com.example.mengenlehreclock.utils.TimeUtil.Companion.hours
import com.example.mengenlehreclock.utils.TimeUtil.Companion.minutes
import com.example.mengenlehreclock.utils.TimeUtil.Companion.seconds

class MLClock {


    fun getMLClock(timeString: String): ClockData {
        val result = convert(timeString)
        val fiveHourRow = getFiveHourRow(result[hours]!!)
        val lastHourRow = getLastHourRow(result[hours]!!)
        val fiftyFiveMinuteRow = getFiftyFiveMinuteRow(result[minutes]!!)
        val lastFiveMinuteRow = getLastFiveMinutes(result[minutes]!!)
        val secondsCircle = getSecondsCircle(result[seconds]!!)

        return ClockData(
            fiveHourRow = fiveHourRow,
            lastHourRow = lastHourRow,
            fiftyFiveMinuteRow = fiftyFiveMinuteRow,
            lastMinuteRow = lastFiveMinuteRow,
            secondsCircle = secondsCircle
        )
    }

    private fun getSecondsCircle(seconds: Int): ClockColor {
        return if (seconds % 2 == 0) {
            YELLOW
        } else {
            OUT
        }
    }


    private fun getLastHourRow(hours: Int): List<ClockColor> {
        return when (hours % 5) {
            0 -> listOf(OUT, OUT, OUT, OUT)
            1 -> listOf(RED, OUT, OUT, OUT)
            2 -> listOf(RED, RED, OUT, OUT)
            3 -> listOf(RED, RED, RED, OUT)
            4 -> listOf(RED, RED, RED, RED)
            else -> throw Exception("something went wrong!")
        }
    }

    private fun getFiveHourRow(hours: Int): List<ClockColor> {
        return when (hours / 5) {
            0 -> listOf(OUT, OUT, OUT, OUT)
            1 -> listOf(RED, OUT, OUT, OUT)
            2 -> listOf(RED, RED, OUT, OUT)
            3 -> listOf(RED, RED, RED, OUT)
            4 -> listOf(RED, RED, RED, RED)
            else -> throw Exception("something went wrong!")
        }
    }

    private fun getFiftyFiveMinuteRow(minutes: Int): List<ClockColor> {
        return when (minutes / 5) {
            0 -> listOf(OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT)
            1 -> listOf(YELLOW, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT)
            2 -> listOf(YELLOW, YELLOW, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT)
            3 -> listOf(YELLOW, YELLOW, RED, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT)
            4 -> listOf(YELLOW, YELLOW, RED, YELLOW, OUT, OUT, OUT, OUT, OUT, OUT, OUT)
            5 -> listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, OUT, OUT, OUT, OUT, OUT, OUT)
            6 -> listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, OUT, OUT, OUT, OUT, OUT)
            7 -> listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, OUT, OUT, OUT, OUT)
            8 -> listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, YELLOW, OUT, OUT, OUT)
            9 -> listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, OUT, OUT)
            10 -> listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, OUT)
            11 -> listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, YELLOW)
            else -> throw Exception("something went wrong!")
        }
    }

    private fun getLastFiveMinutes(minutes: Int): List<ClockColor> {
        return when (minutes % 5) {
            0 -> listOf(OUT, OUT, OUT, OUT)
            1 -> listOf(YELLOW, OUT, OUT, OUT)
            2 -> listOf(YELLOW, YELLOW, OUT, OUT)
            3 -> listOf(YELLOW, YELLOW, YELLOW, OUT)
            4 -> listOf(YELLOW, YELLOW, YELLOW, YELLOW)
            else -> throw Exception("something went wrong!")
        }
    }


}