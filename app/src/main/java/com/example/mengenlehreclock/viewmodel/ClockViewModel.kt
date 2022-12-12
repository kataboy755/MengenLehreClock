package com.example.mengenlehreclock.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mengenlehreclock.MLClock
import com.example.mengenlehreclock.model.ClockData

class ClockViewModel(private val clock: MLClock) : ViewModel() {
    private val _data: MutableLiveData<ClockData> = MutableLiveData<ClockData>()
    val data: LiveData<ClockData>
        get() = _data

    fun onTimeChange(newTime: String) {
        _data.value = clock.getMLClock(newTime)
    }
}
