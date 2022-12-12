package com.example.mengenlehreclock.model


class ClockData(    val fiveHourRow : Any?,
                    val lastHourRow : Any?,
                    val fiftyFiveMinuteRow : Any?,
                    val lastMinuteRow : Any?,
                    val secondsCircle : Any?) {

    companion object {
        fun initData() = ClockData(null,null,null,null,null)
    }

}
