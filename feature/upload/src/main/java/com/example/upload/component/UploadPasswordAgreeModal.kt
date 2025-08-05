package com.example.upload.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.design.theme.LocalColorTheme
import com.example.upload.R

@Composable
fun UploadPasswordAgreeModal(
    name: String,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    val userName = "지현"

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(28.dp))
            .background(LocalColorTheme.current.background.copy(alpha = 0.95f), RoundedCornerShape(28.dp))
            .border(1.dp, LocalColorTheme.current.maincolor[200], shape = RoundedCornerShape(28.dp))
            .padding(top = 33.dp, start = 23.dp, end = 23.dp, bottom = 52.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.ic_notice),
            contentDescription = null,
            modifier = Modifier.size(53.dp)
        )

        Spacer(modifier = Modifier.height(38.dp))

        Text(
            text = " 카카오뱅크, 토스뱅크 내역의 경우\n생년월일 6자리로 비밀번호되어 있습니다!\n\n${name}님의 생년월일 사용을 허락하신다면\n “네”를 눌러주세요!",
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 18.sp,
                textAlign = TextAlign.Center
            ),
            color = Color(0xFF8B8B8B)
        )

        Spacer(modifier = Modifier.height(58.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "네",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                ),
                color = Color(0xFF8B8B8B),
                modifier = Modifier
                    .size(93.dp, 39.dp)
                    .clip(RoundedCornerShape(28.dp))
                    .border(1.dp, LocalColorTheme.current.maincolor[300], RoundedCornerShape(28.dp))
                    .padding(top = 9.dp, bottom = 10.dp)
            )

            Spacer(modifier = Modifier.width(18.dp))

            Text(
                text = "아니요",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                ),
                color = Color(0xFF8B8B8B),
                modifier = Modifier
                    .size(93.dp, 39.dp)
                    .clip(RoundedCornerShape(28.dp))
                    .border(1.dp, LocalColorTheme.current.maincolor[300], RoundedCornerShape(28.dp))
                    .padding(top = 9.dp, bottom = 10.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUploadPasswordAgreeModal() {
    UploadPasswordAgreeModal(
        name = "OO",
        onDismiss = {},
        onConfirm = {}
    )
}