package ui.screen.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import org.koin.compose.koinInject

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeScreen() {
    val viewModel = koinInject<HomeViewModel>()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        viewModel.weatherUIState.value.backgroundGradient.first,
                        viewModel.weatherUIState.value.backgroundGradient.second
                    )
                )
            )
    ) {
        val isShowing by viewModel.isShowing.collectAsState()
        val transitionState = remember { MutableTransitionState(isShowing) }
        transitionState.targetState = isShowing
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    Icons.Default.LocationOn,
                    contentDescription = "Location",
                    modifier = Modifier
                        .size(64.dp)
                        .align(Alignment.CenterVertically)
                        .padding(8.dp)
                )
                Icon(
                    Icons.Default.Settings,
                    contentDescription = "Settings",
                    modifier = Modifier
                        .size(64.dp)
                        .align(Alignment.CenterVertically)
                        .padding(8.dp)
                )
            }
            AnimatedVisibility(
                visibleState = transitionState,
                enter = slideInVertically(
                    animationSpec = tween(durationMillis = 500),
                    initialOffsetY = { fullHeight -> fullHeight }) + fadeIn(
                    animationSpec = tween(durationMillis = 500)
                ),
                exit = fadeOut(animationSpec = tween(durationMillis = 500))
            ) {
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = viewModel.weatherUIState.value.time,
                        style = MaterialTheme.typography.caption

                    )
                    Text(
                        text = viewModel.weatherUIState.value.currentTemperature,
                        style = MaterialTheme.typography.h1
                    )
                    Text(viewModel.weatherUIState.value.todayHigh)
                    Text(viewModel.weatherUIState.value.todayLow)
                }
            }
        }
    }
}