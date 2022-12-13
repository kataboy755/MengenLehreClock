package com.example.mengenlehreclock.viewmodel

import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.mengenlehreclock.MLClock
import com.example.mengenlehreclock.model.ClockData
import com.example.mengenlehreclock.model.ClockData.Companion.OUT
import com.example.mengenlehreclock.model.ClockData.Companion.RED
import com.example.mengenlehreclock.model.ClockData.Companion.YELLOW


class ClockViewModelTest {
    private val clock = MLClock()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: ClockViewModel

    @Before
    fun setup() {
        viewModel = ClockViewModel(clock)
    }

    @Test
    fun `viewmodel specific hour clock value 1`() {
        val time = "11:56:01 PM"
        viewModel.onTimeChange(time)
        Assert.assertEquals(getSpecific24ClockData(), viewModel.data.value)
    }

    @Test
    fun `viewmodel specific clock value 2`() {
        val time = "12:03:00 AM"
        viewModel.onTimeChange(time)
        Assert.assertEquals(getSpecific12ClockData(), viewModel.data.value)
    }


    private fun getSpecific12ClockData(): ClockData {
        val fiveHourRow = listOf(RED, RED, RED, RED)
        val lastHourRow = listOf(RED, RED, RED, RED)
        val fiftyFiveMinuteRow =
            listOf(OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT)
        val lastMinuteRow = listOf(YELLOW, YELLOW, YELLOW, OUT)
        return ClockData(
            fiveHourRow = fiveHourRow,
            lastHourRow = lastHourRow,
            fiftyFiveMinuteRow = fiftyFiveMinuteRow,
            lastMinuteRow = lastMinuteRow,
            secondsCircle = YELLOW
        )
    }

    private fun getSpecific24ClockData(): ClockData {
        val fiveHourRow = listOf(RED, RED, RED, RED)
        val lastHourRow = listOf(RED, RED, RED, OUT)
        val fiftyFiveMinuteRow =
            listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, YELLOW)
        val lastMinuteRow = listOf(YELLOW, OUT, OUT, OUT)
        return ClockData(
            fiveHourRow = fiveHourRow,
            lastHourRow = lastHourRow,
            fiftyFiveMinuteRow = fiftyFiveMinuteRow,
            lastMinuteRow = lastMinuteRow,
            secondsCircle = OUT
        )
    }

}