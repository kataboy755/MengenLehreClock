package com.example.mengenlehreclock.utils

import android.util.Log
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
            var temp = time.get(Calendar.HOUR_OF_DAY)
            if (temp == 0) temp = 24
            Log.d("TimeUtil","hours: $temp minutes ${time.get(Calendar.MINUTE)} seconds ${time.get(Calendar.SECOND)}")
            return mapOf(
                hours to temp,
                minutes to time.get(Calendar.MINUTE),
                seconds to time.get(Calendar.SECOND)
            )
        }
    }

}