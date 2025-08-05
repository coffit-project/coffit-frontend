package com.example.upload

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.design.theme.LocalColorTheme
import com.example.upload.component.UploadPasswordAgreeModal

@Composable
fun UploadScreen() {
    var selectedBank by remember { mutableStateOf("주거래 은행 선택하기") }
    val bankList = listOf("KB국민은행", "신한은행", "카카오뱅크", "토스뱅크", "기업은행")


    var showPasswordAgreeModal by remember { mutableStateOf(false) }
    val userName = "홍지현"

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(R.drawable.img_bear),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 155.dp)
                    .size(111.dp, 119.dp)
            )

            Text(
                text = "소비 패턴을 분석해 볼까요?",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Medium),
                color = LocalColorTheme.current.black,
                modifier = Modifier.padding(top = 39.dp)
            )

            Text(
                text = "내 주거래 은행을 선택해주세요!",
                style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Medium),
                color = LocalColorTheme.current.maincolor[200],
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 39.dp, start = 60.dp)
            )

            Spacer(modifier = Modifier.height(11.dp))

            CustomDropdownMenu(
                options = bankList,
                selectedOption = selectedBank,
                onOptionSelected = { bank ->
                    selectedBank = bank
                    if (bank == "카카오뱅크" || bank == "토스뱅크") {
                        showPasswordAgreeModal = true
                    }
                }
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 48.dp, start = 50.dp, end = 49.dp)
                    .clip(RoundedCornerShape(28.dp))
                    .background(Color(0xFFFFE4D9))
                    .border(2.dp, LocalColorTheme.current.maincolor[300], shape = RoundedCornerShape(28.dp))
                    .padding(top = 11.dp, start = 23.dp, end = 31.dp, bottom = 9.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_file),
                    contentDescription = null,
                    modifier = Modifier.size(42.dp, 35.dp)
                )

                Text(
                    text = "소비 파일을 업로드 해주세요!",
                    style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Bold),
                    color = LocalColorTheme.current.gray[500],
                    modifier = Modifier.padding(start = 7.dp)
                )
            }
        }

        // 모달 띄우기
        if (showPasswordAgreeModal) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                // 오버레이 (뒷배경)
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.3f))
                        .clickable { showPasswordAgreeModal = false }
                )

                // 모달 본문
                Box(
                    modifier = Modifier
                        .align(Alignment.Center) // ⭐️ 화면 "진짜" 정중앙
                        .padding(start = 35.dp, end = 36.dp)
                ) {
                    UploadPasswordAgreeModal(
                        name = userName,
                        onDismiss = { showPasswordAgreeModal = false },
                        onConfirm = { showPasswordAgreeModal = false }
                    )
                }
            }
        }
    }
}

@Composable
fun CustomDropdownMenu(
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    // 드롭다운 버튼 (원하는 위치)
    Box(
        modifier = Modifier
            .width(291.dp)
            .heightIn(min = 37.dp)
            .clip(RoundedCornerShape(28.dp))
            .background(LocalColorTheme.current.white)
            .border(
                width = 1.dp,
                color = LocalColorTheme.current.maincolor[200],
                shape = RoundedCornerShape(28.dp)
            )
            .clickable { expanded = !expanded }
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = selectedOption,
                color = LocalColorTheme.current.gray[500],
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium
            )
            Image(
                painter = painterResource(
                    if (expanded) R.drawable.ic_arrow_up else R.drawable.ic_arrow_down
                ),
                contentDescription = "드롭다운",
                modifier = Modifier.size(20.dp)
            )
        }
    }

    // 메뉴 오버레이로 화면 수평 중앙!
    if (expanded) {
        Box(
            Modifier
                .fillMaxSize()
                .background(Color.Transparent)
                .clickable { expanded = false }
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .width(291.dp)
                    .clip(RoundedCornerShape(28.dp))
                    .background(LocalColorTheme.current.background.copy(alpha = 0.95f), RoundedCornerShape(28.dp))
                    .border(1.dp, LocalColorTheme.current.maincolor[200], shape = RoundedCornerShape(28.dp))
            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 21.dp, bottom = 22.dp)
                ) {
                    options.forEachIndexed { idx, option ->
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    onOptionSelected(option)
                                    expanded = false
                                }
                                .padding(horizontal = 16.dp)
                        ) {
                            Text(
                                text = option,
                                color = LocalColorTheme.current.gray[400],
                                style = TextStyle(
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Medium,
                                )
                            )

                            // 마지막이 아니면 Divider 추가
                            if (idx < options.lastIndex) {
                                Divider(
                                    color = Color(0xFFE1E1E1),
                                    thickness = 1.5.dp,
                                    modifier = Modifier.padding(vertical = 9.dp) // 메뉴와 정렬
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUploadScreen() {
    UploadScreen()
}