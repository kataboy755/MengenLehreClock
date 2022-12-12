package com.example.mengenlehreclock

import com.example.mengenlehreclock.model.ClockData.Companion.OUT
import com.example.mengenlehreclock.model.ClockData.Companion.RED
import com.example.mengenlehreclock.model.ClockData.Companion.YELLOW
import org.junit.Assert
import org.junit.Test

class ClockTest {
    private val clock = MLClock()

    @Test
    fun `clock even seconds should return color`() {
        val actual = clock.getMLClock("00:00:00").secondsCircle
        val expected = YELLOW
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `clock odd seconds should return nothing`() {
        val actual = clock.getMLClock("00:00:01").secondsCircle
        val expected = OUT
        Assert.assertEquals(expected, actual)
    }

    //for good measure
    @Test
    fun `clock even seconds should return color2`() {
        val actual = clock.getMLClock("00:00:56").secondsCircle
        val expected = YELLOW
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `clock odd seconds should return nothing2`() {
        val actual = clock.getMLClock("00:00:31").secondsCircle
        val expected = OUT
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `clock 1 minutes should return color`() {
        val actual = clock.getMLClock("00:01:00").lastMinuteRow
        val expected = listOf(YELLOW, OUT, OUT, OUT)
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `clock 2 minutes should return color`() {
        val actual = clock.getMLClock("00:02:00").lastMinuteRow
        val expected = listOf(YELLOW, YELLOW, OUT, OUT)
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `clock 3 minutes should return color`() {
        val actual = clock.getMLClock("00:03:00").lastMinuteRow
        val expected = listOf(YELLOW, YELLOW, YELLOW, OUT)
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `clock 4 minutes should return color`() {
        val actual = clock.getMLClock("00:04:00").lastMinuteRow
        val expected = listOf(YELLOW, YELLOW, YELLOW, YELLOW)
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `clock 5 minutes should return color`() {
        val temp = clock.getMLClock("00:05:00")
        val actual1 = temp.lastMinuteRow
        val actual2 = temp.fiftyFiveMinuteRow
        val expected1 = listOf(OUT, OUT, OUT, OUT)
        val expected2 = listOf(YELLOW, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT)
        Assert.assertEquals(expected1, actual1)
        Assert.assertEquals(expected2, actual2)
    }

    @Test
    fun `clock 8 minutes should return color`() {
        val temp = clock.getMLClock("00:08:00")
        val actual1 = temp.lastMinuteRow
        val actual2 = temp.fiftyFiveMinuteRow
        val expected1 = listOf(YELLOW, YELLOW, YELLOW, OUT)
        val expected2 = listOf(YELLOW, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT)
        Assert.assertEquals(expected1, actual1)
        Assert.assertEquals(expected2, actual2)
    }

    @Test
    fun `clock 15 minutes should return color`() {
        val temp = clock.getMLClock("00:15:00")
        val actual1 = temp.lastMinuteRow
        val actual2 = temp.fiftyFiveMinuteRow
        val expected1 = listOf(OUT, OUT, OUT, OUT)
        val expected2 = listOf(YELLOW, YELLOW, RED, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT)
        Assert.assertEquals(expected1, actual1)
        Assert.assertEquals(expected2, actual2)
    }

    @Test
    fun `clock 20 minutes should return color`() {
        val temp = clock.getMLClock("00:20:00")
        val actual1 = temp.lastMinuteRow
        val actual2 = temp.fiftyFiveMinuteRow
        val expected1 = listOf(OUT, OUT, OUT, OUT)
        val expected2 = listOf(YELLOW, YELLOW, RED, YELLOW, OUT, OUT, OUT, OUT, OUT, OUT, OUT)
        Assert.assertEquals(expected1, actual1)
        Assert.assertEquals(expected2, actual2)
    }

    @Test
    fun `clock 25 minutes should return color`() {
        val temp = clock.getMLClock("00:25:00")
        val actual1 = temp.lastMinuteRow
        val actual2 = temp.fiftyFiveMinuteRow
        val expected1 = listOf(OUT, OUT, OUT, OUT)
        val expected2 = listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, OUT, OUT, OUT, OUT, OUT, OUT)
        Assert.assertEquals(expected1, actual1)
        Assert.assertEquals(expected2, actual2)
    }

    @Test
    fun `clock 55 minutes should return color`() {
        val temp = clock.getMLClock("00:55:00")
        val actual1 = temp.lastMinuteRow
        val actual2 = temp.fiftyFiveMinuteRow
        val expected1 = listOf(OUT, OUT, OUT, OUT)
        val expected2 = listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, YELLOW)
        Assert.assertEquals(expected1, actual1)
        Assert.assertEquals(expected2, actual2)
    }

    @Test
    fun `clock 59 minutes should return color`() {
        val temp = clock.getMLClock("00:59:00")
        val actual1 = temp.lastMinuteRow
        val actual2 = temp.fiftyFiveMinuteRow
        val expected1 = listOf(YELLOW, YELLOW, YELLOW, YELLOW)
        val expected2 = listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, YELLOW)
        Assert.assertEquals(expected1, actual1)
        Assert.assertEquals(expected2, actual2)
    }

    @Test
    fun `clock 1 hour should return color`() {
        val temp = clock.getMLClock("01:00:00")
        val actual = temp.lastHourRow
        val expected = listOf(RED, OUT, OUT, OUT)
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `clock 2 hour should return color`() {
        val temp = clock.getMLClock("02:00:00")
        val actual = temp.lastHourRow
        val expected = listOf(RED, RED, OUT, OUT)
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `clock 3 hour should return color`() {
        val temp = clock.getMLClock("03:00:00")
        val actual = temp.lastHourRow
        val expected = listOf(RED, RED, RED, OUT)
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `clock 4 hour should return color`() {
        val temp = clock.getMLClock("04:00:00")
        val actual = temp.lastHourRow
        val expected = listOf(RED, RED, RED, RED)
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `clock 5 hours should return color`() {
        val temp = clock.getMLClock("05:00:00")
        val actual1 = temp.lastHourRow
        val actual2 = temp.fiveHourRow
        val expected1 = listOf(OUT, OUT, OUT, OUT)
        val expected2 = listOf(RED, OUT, OUT, OUT)
        Assert.assertEquals(expected1, actual1)
        Assert.assertEquals(expected2, actual2)
    }

    @Test
    fun `clock 9 hours should return color`() {
        val temp = clock.getMLClock("09:00:00")
        val actual1 = temp.lastHourRow
        val actual2 = temp.fiveHourRow
        val expected1 = listOf(RED, RED, RED, RED)
        val expected2 = listOf(RED, OUT, OUT, OUT)
        Assert.assertEquals(expected1, actual1)
        Assert.assertEquals(expected2, actual2)
    }

    @Test
    fun `clock 10 hours should return color`() {
        val temp = clock.getMLClock("10:00:00")
        val actual1 = temp.lastHourRow
        val actual2 = temp.fiveHourRow
        val expected1 = listOf(OUT, OUT, OUT, OUT)
        val expected2 = listOf(RED, RED, OUT, OUT)
        Assert.assertEquals(expected1, actual1)
        Assert.assertEquals(expected2, actual2)
    }

    @Test
    fun `clock 15 hours should return color`() {
        val temp = clock.getMLClock("15:00:00")
        val actual1 = temp.lastHourRow
        val actual2 = temp.fiveHourRow
        val expected1 = listOf(OUT, OUT, OUT, OUT)
        val expected2 = listOf(RED, RED, RED, OUT)
        Assert.assertEquals(expected1, actual1)
        Assert.assertEquals(expected2, actual2)
    }

    @Test
    fun `clock 20 hours should return color`() {
        val temp = clock.getMLClock("20:00:00")
        val actual1 = temp.lastHourRow
        val actual2 = temp.fiveHourRow
        val expected1 = listOf(OUT, OUT, OUT, OUT)
        val expected2 = listOf(RED, RED, RED, RED)
        Assert.assertEquals(expected1, actual1)
        Assert.assertEquals(expected2, actual2)
    }

    @Test
    fun `clock 22 hours should return color`() {
        val temp = clock.getMLClock("22:00:00")
        val actual1 = temp.lastHourRow
        val actual2 = temp.fiveHourRow
        val expected1 = listOf(RED, RED, OUT, OUT)
        val expected2 = listOf(RED, RED, RED, RED)
        Assert.assertEquals(expected1, actual1)
        Assert.assertEquals(expected2, actual2)
    }

    //TODO: we are already testing am pm in viewmodel, but need to do so more extensively here



}