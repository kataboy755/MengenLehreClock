package com.example.mengenlehreclock.model

import androidx.compose.ui.graphics.Color


data class ClockData(
    val fiveHourRow: List<ClockColor>,
    val lastHourRow: List<ClockColor>,
    val fiftyFiveMinuteRow: List<ClockColor>,
    val lastMinuteRow: List<ClockColor>,
    val secondsCircle: ClockColor
) {

    companion object {
        val OUT = ClockColor.OUT
        val RED = ClockColor.RED
        val YELLOW = ClockColor.YELLOW
        fun initData() = ClockData(
            MutableList(4) { OUT },
            MutableList(4) { OUT },
            MutableList(11) { OUT },
            MutableList(4) { OUT },
            YELLOW
        )
        fun toColor(color: ClockColor):Color {
            return when(color) {
                OUT -> Color.Transparent
                RED -> Color.Red
                YELLOW -> Color.Yellow
                else -> {Color.Transparent}
            }
        }
    }




}
