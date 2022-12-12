package com.example.mengenlehreclock

import android.app.Application
import com.example.mengenlehreclock.viewmodel.ClockViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class ClockApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(appModule, viewModelModule))
        }
    }

    private val appModule = module {
        single { MLClock() }
    }

    private val viewModelModule = module {
        viewModel { ClockViewModel(get()) }
    }
}