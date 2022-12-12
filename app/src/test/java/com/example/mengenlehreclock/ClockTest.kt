package com.example.mengenlehreclock

import org.junit.Assert
import org.junit.Test

class ClockTest {
    private val clock = MLClock()

    //basically just test all the minute/hour/second per increment, dont forget to add stuff for midnight and am/pm

    @Test
    fun `clock even seconds should return color`() {
        val actual = clock.getMLClock("00:00:00").secondsCircle
        val expected = null
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `clock odd seconds should return nothing`() {
        val actual = clock.getMLClock("00:00:01").secondsCircle
        val expected = null
        Assert.assertEquals(expected, actual)
    }

    //for good measure
    @Test
    fun `clock even seconds should return color2`() {
        val actual = clock.getMLClock("00:00:56").secondsCircle
        val expected = null
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `clock odd seconds should return nothing2`() {
        val actual = clock.getMLClock("00:00:31").secondsCircle
        val expected = null
        Assert.assertEquals(expected, actual)
    }

    //same for minutes but more complicated: ie one, two, three, four minutes and five, ten, fifteen... minutes + some combos

    //same for hours but more complicated: one two three four five ten fifteen twenty twentythree, zero AM + PM ? null value necessary? init value necessary?
}