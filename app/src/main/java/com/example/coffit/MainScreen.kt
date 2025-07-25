package com.example.coffit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.design.theme.ThemeProvider

@Composable
fun MainScreen(
    content: @Composable () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // 화면 전체를 채우는 컨텐츠
            Box(
                modifier = Modifier.weight(1f)
            ) {
                content()
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewMainScreen() {
    ThemeProvider {
        MainScreen {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "메인 화면 입니다.")
            }
        }
    }
}