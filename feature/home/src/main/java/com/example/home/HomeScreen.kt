package com.example.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.design.theme.LocalColorTheme

@Composable
fun HomeScreen() {
    val expenseAmount = "107,000"

    // 절약 카테고리 더미 데이터
    val saveItems = listOf(
        "카페" to "55,400원",
        "카페" to "25,000원"
    )

    val userName = "지현"

    val selectedInvestFields = listOf(
        "IT・AI", "엔터・게임", "교육・소프트웨어"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 31.dp, end = 30.dp)
            .background(LocalColorTheme.current.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 68.dp)
                .clip(RoundedCornerShape(15.dp))
                .border(1.dp, LocalColorTheme.current.gray[300])
                .background(LocalColorTheme.current.white)
                .padding(top = 17.dp, start = 19.dp, end = 19.dp, bottom = 15.dp)
        ) {
            Text(
                text = "소비 패턴을 분석해 볼까요?",
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold),
                color = LocalColorTheme.current.black
            )

            Spacer(modifier = Modifier.height(21.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(28.dp))
                    .background(LocalColorTheme.current.maincolor[200])
                    .padding(top = 15.dp, start = 17.dp, end = 12.dp, bottom = 14.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "소비 내역 업로드 하러가기",
                    style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Normal),
                    color = LocalColorTheme.current.black
                )

                Image(
                    painter = painterResource(R.drawable.ic_right_arrow),
                    contentDescription = null,
                    modifier = Modifier
                        .width(12.dp)
                        .height(18.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .border(1.dp, LocalColorTheme.current.gray[300])
                .background(LocalColorTheme.current.white)
                .padding(horizontal = 19.dp, vertical = 17.dp)
        ) {
            Text(
                text = "이번 달 소비 분석이에요!",
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold),
                color = LocalColorTheme.current.black
            )

            Spacer(modifier = Modifier.height(21.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.img_circlegraph),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .padding(bottom = 5.dp)
                )

                Column(
                    modifier = Modifier.padding(top = 14.dp, start = 24.dp)
                ) {
                    Text(
                        text = "지금까지",
                        style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Normal),
                        color = LocalColorTheme.current.black
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row {
                        Text(
                            text = "${expenseAmount}원",
                            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Normal),
                            color = LocalColorTheme.current.black
                        )

                        Spacer(modifier = Modifier.width(5.dp))

                        Text(
                            text = "소비했어요",
                            style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Normal),
                            color = LocalColorTheme.current.black,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(27.dp))

                    Text(
                        text = "소비 자세히 보기",
                        style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal),
                        color = LocalColorTheme.current.maincolor[300],
                        modifier = Modifier.padding(start = 84.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .border(1.dp, LocalColorTheme.current.gray[300])
                .background(LocalColorTheme.current.white)
                .padding(top = 15.dp, start = 19.dp, end = 19.dp, bottom = 17.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_coin),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp)
                )

                Spacer(modifier = Modifier.width(13.dp))

                Text(
                    text = "절약 가능한 금액은 얼마일까요?",
                    style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold),
                    color = LocalColorTheme.current.black
                )
            }

            Spacer(modifier = Modifier.height(19.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                saveItems.forEach { (category, amount) ->
                    saveAmountItem(
                        category = category,
                        amount = amount
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .border(1.dp, LocalColorTheme.current.gray[300])
                .background(LocalColorTheme.current.white)
                .padding(top = 13.dp, start = 20.dp, end = 20.dp, bottom = 14.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_bulb),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp)
                )

                Spacer(modifier = Modifier.width(13.dp))

                Text(
                    text = "${userName}님이 선택하신 투자 분야예요",
                    style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold),
                    color = LocalColorTheme.current.black
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                selectedInvestFields.chunked(2).forEach { chunk ->
                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        chunk.forEach { field ->
                            investItem(text = field)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Text(
                    text = "추천받기",
                    style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal),
                    color = LocalColorTheme.current.maincolor[300],
                    modifier = Modifier
                        .padding(start = 28.dp, end = 68.dp)
                )

                Text(
                    text = "|",
                    style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal),
                    color = LocalColorTheme.current.maincolor[300]
                )

                Text(
                    text = "수정하기",
                    style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal),
                    color = LocalColorTheme.current.maincolor[300],
                    modifier = Modifier
                        .padding(start = 70.dp, end = 29.dp)
                )
            }
        }
    }
}

@Composable
fun saveAmountItem(
    category: String,
    amount: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(47.dp)
            .border(
                width = 1.dp,
                color = LocalColorTheme.current.maincolor[300],
                shape = RoundedCornerShape(28.dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(start = 12.dp)
                .background(
                    color = LocalColorTheme.current.maincolor[100],
                    shape = RoundedCornerShape(28.dp)
                )
                .padding(top = 4.dp, start = 13.dp, end = 13.dp, bottom = 3.dp)
        ) {
            Text(
                text = category,
                style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Normal),
                color = LocalColorTheme.current.black
            )
        }

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = amount,
            style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Normal),
            color = LocalColorTheme.current.black
        )
    }
}

@Composable
fun investItem(text: String) {
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = LocalColorTheme.current.maincolor[300],
                shape = RoundedCornerShape(28.dp)
            )
            .background(
                color = Color(0xFFFFE7DE),
                shape = RoundedCornerShape(28.dp)
            )
            .padding(vertical = 9.dp, horizontal = 20.dp)
    ) {
        Text(
            text = "# $text",
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = LocalColorTheme.current.maincolor[300]
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}