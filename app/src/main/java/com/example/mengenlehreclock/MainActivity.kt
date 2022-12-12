package com.example.mengenlehreclock

import android.os.Bundle
import android.widget.TextClock
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.widget.doOnTextChanged
import com.example.mengenlehreclock.model.ClockColor
import com.example.mengenlehreclock.model.ClockData
import com.example.mengenlehreclock.model.ClockData.Companion.toColor
import com.example.mengenlehreclock.ui.theme.MengenLehreClockTheme
import com.example.mengenlehreclock.viewmodel.ClockViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel: ClockViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MengenLehreClockTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    observeViewModel(viewModel)
                }
            }
        }
    }
}

@Composable
fun observeViewModel(viewModel: ClockViewModel) {
    val data: ClockData by viewModel.data.observeAsState(initial = ClockData.initData())
    Clock(data = data, onTimeChange = { viewModel.onTimeChange(it) })
}

@Composable
fun Clock(data: ClockData, onTimeChange: (String) -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row {
            Circle(toColor(data.secondsCircle))
        }
        Row(modifier = Modifier.padding(10.dp)) {
            for (color: ClockColor in data.fiveHourRow) {
                Rectangle(toColor(color))
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
        Row(modifier = Modifier.padding(10.dp)) {
            for (color: ClockColor in data.lastHourRow) {
                Rectangle(toColor(color))
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
        Row(modifier = Modifier.padding(5.dp)) {
            for (color: ClockColor in data.fiftyFiveMinuteRow) {
                RectangleSmall(toColor(color))
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
        Row(modifier = Modifier.padding(10.dp, 10.dp)) {
            for (color: ClockColor in data.lastMinuteRow) {
                Rectangle(toColor(color))
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
        Row(
            modifier = Modifier
                .padding(10.dp, 10.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            AndroidView(
                factory = { context ->
                    TextClock(
                        context,
                    ).apply {
                        doOnTextChanged { time, _, _, _ ->
                            onTimeChange(time.toString().trim())
                        }
                        format12Hour?.let { this.format12Hour = " hh:mm:ss a" }
                        format24Hour?.let { this.format24Hour = " hh:mm:ss" }
                        textSize.let { this.textSize = 50f }


                    }
                }
            )
        }
    }

}

@Composable
fun Circle(color: Color) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(color)
                .border(2.dp, Color.Black, CircleShape)
        )
    }
}

@Composable
fun Rectangle(color: Color) {
    Box(
        modifier = Modifier
            .height(50.dp)
            .width(70.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .border(2.dp, Color.Black, RectangleShape)

    )

}

@Composable
fun RectangleSmall(color: Color) {
    Box(
        modifier = Modifier
            .height(50.dp)
            .width(20.dp)
            .background(color)
            .border(2.dp, Color.Black, RectangleShape)

    )

}

