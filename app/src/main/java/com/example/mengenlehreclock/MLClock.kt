package com.example.mengenlehreclock


import com.example.mengenlehreclock.model.ClockData
import com.example.mengenlehreclock.model.ClockData.Companion.OUT
import com.example.mengenlehreclock.model.ClockData.Companion.YELLOW

class MLClock {
    fun getMLClock(time: String): ClockData {
        val fiveHourRow = listOf(OUT, OUT, OUT, OUT)
        val lastHourRow = listOf(OUT, OUT, OUT, OUT)
        val fiftyFiveMinuteRow = listOf(OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT)
        val lastMinuteRow = listOf(OUT, OUT, OUT, OUT)
        return ClockData(fiveHourRow, lastHourRow, fiftyFiveMinuteRow, lastMinuteRow, YELLOW)
    }
}