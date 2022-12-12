package com.example.mengenlehreclock.viewmodel

import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.mengenlehreclock.MLClock
import com.example.mengenlehreclock.model.ClockData


class ClockViewModelTest {
    private val clock = MLClock()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: ClockViewModel

    @Before
    fun setup(){
        viewModel = ClockViewModel(clock)
    }

    //we are just testing viewmodel, not actual clock values, but putting 24/12 here so I don't forget later
    @Test
    fun `viewmodel specific 24 hour clock value`() {
        val time = "23: 56: 01"
        viewModel.onTimeChange(time)
        Assert.assertEquals(viewModel.data.value, getSpecific24ClockData())
    }

    @Test
    fun `viewmodel specific 12 clock value`() {
        val time = "12: 03: 00 AM"
        viewModel.onTimeChange(time)
        Assert.assertEquals(viewModel.data.value, getSpecific12ClockData())
    }


    private fun getSpecific12ClockData() : ClockData {
        val fiveHourRow = null
        val lastHourRow = null
        val fiftyFiveMinuteRow = null
        val lastMinuteRow = null
        return ClockData( fiveHourRow = fiveHourRow, lastHourRow = lastHourRow, fiftyFiveMinuteRow = fiftyFiveMinuteRow, lastMinuteRow = lastMinuteRow, secondsCircle = null)
    }

    private fun getSpecific24ClockData() : ClockData {
        val fiveHourRow = null
        val lastHourRow = null
        val fiftyFiveMinuteRow = null
        val lastMinuteRow = null
        return ClockData( fiveHourRow = fiveHourRow, lastHourRow = lastHourRow, fiftyFiveMinuteRow = fiftyFiveMinuteRow, lastMinuteRow = lastMinuteRow, secondsCircle = null)
    }

}