package com.example.mengenlehreclock.utils

import java.text.SimpleDateFormat
import java.util.*

class TimeUtil {
    companion object {
        val hours = "hours"
        val minutes = "minutes"
        val seconds = "seconds"
        fun convert(timeString: String): Map<String, Int> {
            val time = Calendar.getInstance()
                .apply { time = SimpleDateFormat.getTimeInstance().parse(timeString) as Date }
            val temp = time.get(Calendar.HOUR_OF_DAY)
            return mapOf(
                hours to temp,
                minutes to time.get(Calendar.MINUTE),
                seconds to time.get(Calendar.SECOND)
            )
        }
    }

}