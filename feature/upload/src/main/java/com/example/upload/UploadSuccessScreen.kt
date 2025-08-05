package com.example.upload

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.design.theme.LocalColorTheme

@Composable
fun UploadSuccessScreen() {
    // 토스트 보임 상태 관리
    var showToast by remember { mutableStateOf(true) }

    // 1.5초 후 자동으로 사라지게
    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(2000)
        showToast = false
    }

    val uploadedFile = "coffit_financial_data_20250709.xlsx"
    val dataCount = 250

    Box(modifier = Modifier.fillMaxSize()) {
        // 상단에 토스트 메시지 (중앙 상단에 띄우기)
        AnimatedVisibility(
            visible = showToast,
            enter = androidx.compose.animation.fadeIn(),
            exit = androidx.compose.animation.fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 79.dp)
            ) {
                SuccessToast("저장 성공 !")
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(LocalColorTheme.current.background),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 149.dp),
            ) {
                Image(
                    painter = painterResource(R.drawable.img_upload_success),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 126.dp, end = 127.dp)
                        .size(137.dp, 144.dp)
                )

                Spacer(modifier = Modifier.height(29.dp))

                Text(
                    text = "업로드된 파일",
                    style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium, textAlign = TextAlign.Start),
                    color = LocalColorTheme.current.gray[500],
                    modifier = Modifier.padding(start = 39.dp)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 6.dp, start = 39.dp, end = 40.dp)
                        .clip(RoundedCornerShape(28.dp))
                        .border(1.dp, LocalColorTheme.current.maincolor[200], RoundedCornerShape(28.dp))
                        .padding(top = 9.dp, start = 14.dp, end = 14.dp, bottom = 10.dp)
                ) {
                    Text(
                        text = uploadedFile,
                        style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium),
                        color = LocalColorTheme.current.gray[400]
                    )
                }

                Spacer(modifier = Modifier.height(53.dp))

                Text(
                    text = "총 ${dataCount.toString()}건의 데이터가 업로드되었습니다 !",
                    style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium),
                    color = LocalColorTheme.current.gray[500],
                    modifier = Modifier.padding(start = 72.dp, end = 73.dp)
                )

                Spacer(modifier = Modifier.height(53.dp))

                Text(
                    text = "업로드 된 파일에 대한\n\n자동 분류 및 분석을 시작합니다 !",
                    style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium, lineHeight = 12.sp, textAlign = TextAlign.Center),
                    color = LocalColorTheme.current.gray[500],
                    modifier = Modifier.padding(start = 99.dp, end = 100.dp)
                )

                Spacer(modifier = Modifier.height(106.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 113.dp, end = 114.dp)
                        .clip(RoundedCornerShape(28.dp))
                        .background(Color(0xFFFFE7DE))
                        .border(1.dp, LocalColorTheme.current.maincolor[200], RoundedCornerShape(28.dp))
                        .padding(top = 9.dp, start = 14.dp, end = 14.dp, bottom = 10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "지출 분석 하러 가기",
                        style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Bold),
                        color = LocalColorTheme.current.maincolor[200]
                    )
                }
            }
        }
    }
}

@Composable
fun SuccessToast(text: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(28.dp))
            .border(width = 1.dp, color = LocalColorTheme.current.maincolor[200], shape = RoundedCornerShape(28.dp))
            .background(Color(0xFFFFE7DE))
            .padding(vertical = 10.dp, horizontal = 24.dp)
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(28.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = LocalColorTheme.current.maincolor[200],
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUploadSuccessScreen() {
    UploadSuccessScreen()
}