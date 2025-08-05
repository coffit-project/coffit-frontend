package com.example.recommend

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.design.theme.LocalColorTheme

data class RecommendItem(
    val category: String,
    val iconRes: Int,
    val name: String,
    val price: String
)

@Composable
fun RecommendScreen() {
    val dummyRecommendList = listOf(
        RecommendItem("반도체", R.drawable.img_sk_logo, "SK하이닉스", "283,500원"),
        RecommendItem("IT", R.drawable.img_sk_logo, "NAVER", "201,000원"),
        RecommendItem("게임", R.drawable.img_sk_logo, "카카오게임즈", "43,200원")
    )
    val popularList = listOf(
        RecommendItem("반도체", R.drawable.img_sk_logo, "SK하이닉스", "283,500원"),
        RecommendItem("IT", R.drawable.img_sk_logo, "NAVER", "201,000원"),
        RecommendItem("게임", R.drawable.img_sk_logo, "카카오게임즈", "43,200원"),
        RecommendItem("플랫폼", R.drawable.img_sk_logo, "카카오", "45,800원"),
        RecommendItem("자동차", R.drawable.img_sk_logo, "현대차", "196,000원"),
        RecommendItem("음식료", R.drawable.img_sk_logo, "오뚜기", "570,000원"),
        RecommendItem("유통", R.drawable.img_sk_logo, "롯데쇼핑", "94,300원"),
        RecommendItem("바이오", R.drawable.img_sk_logo, "삼성바이오로직스", "792,000원"),
        RecommendItem("통신", R.drawable.img_sk_logo, "KT", "34,600원"),
        RecommendItem("금융", R.drawable.img_sk_logo, "신한지주", "38,900원")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LocalColorTheme.current.background)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 43.dp, start = 19.dp, end = 18.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(R.drawable.ic_back),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )

            Text(
                text = "투자 종목 추천",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Medium),
                color = LocalColorTheme.current.black
            )

            Image(
                painter = painterResource(R.drawable.ic_refresh),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 14.dp, start = 30.dp, end = 31.dp)
                .background(LocalColorTheme.current.white)
                .clip(RoundedCornerShape(15.dp))
                .border(1.dp, LocalColorTheme.current.gray[300], shape = RoundedCornerShape(15.dp))
                .padding(top = 17.dp, start = 18.dp, end = 18.dp, bottom = 18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "투자 종목 바탕으로 추천하는 종목입니다!",
                style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Medium),
                color = LocalColorTheme.current.gray[500]
            )

            Spacer(modifier = Modifier.height(5.dp))

            Column {
                dummyRecommendList.forEach {
                    reconmandInvestItem(
                        category = it.category,
                        iconRes = it.iconRes,
                        name = it.name,
                        price = it.price
                    )
                }
            }
        }

        Text(
            text = "인기 종목 순위",
            style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.SemiBold),
            color = LocalColorTheme.current.black,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 20.dp, start = 36.dp, bottom = 10.dp)
        )

        Column(
            modifier = Modifier.padding(start = 28.dp, end = 41.dp)
        ) {
            popularList.forEachIndexed { idx, item ->
                popularInvestItem(
                    rank = idx + 1,
                    category = item.category,
                    iconRes = item.iconRes,
                    name = item.name,
                    price = item.price
                )
            }
        }

        Spacer(modifier = Modifier.height(76.dp))
    }
}

@Composable
fun reconmandInvestItem(
    category: String,
    iconRes: Int,
    name: String,
    price: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 카테고리 태그
            Text(
                text = category,
                style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Medium),
                color = LocalColorTheme.current.black,
                modifier = Modifier
                    .background(
                        LocalColorTheme.current.maincolor[200],
                        shape = RoundedCornerShape(15.dp)
                    )
                    .padding(horizontal = 10.dp, vertical = 5.dp)
            )

            // 아이콘
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .size(30.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .background(LocalColorTheme.current.gray[300])
            )

            // 종목명
            Text(
                text = name,
                style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.SemiBold),
                color = LocalColorTheme.current.black
            )
        }

        Text(
            text = price,
            style = TextStyle(fontSize = 13.sp, fontWeight = FontWeight.SemiBold),
            color = LocalColorTheme.current.black
        )
    }
}

@Composable
fun popularInvestItem(
    rank: Int,
    category: String,
    iconRes: Int,
    name: String,
    price: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 순위
            Box(
                modifier = Modifier
                    .width(26.dp)
                    .padding(end = 8.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Text(
                    text = rank.toString(),
                    style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Medium),
                    color = LocalColorTheme.current.black,
                )
            }

            // 카테고리 태그
            Text(
                text = category,
                style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Medium),
                color = LocalColorTheme.current.black,
                modifier = Modifier
                    .background(
                        LocalColorTheme.current.maincolor[200],
                        shape = RoundedCornerShape(15.dp)
                    )
                    .padding(horizontal = 10.dp, vertical = 5.dp)
            )

            // 아이콘
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .size(30.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .background(LocalColorTheme.current.gray[300])
            )

            // 종목명
            Text(
                text = name,
                style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.SemiBold),
                color = LocalColorTheme.current.black
            )
        }

        Text(
            text = price,
            style = TextStyle(fontSize = 13.sp, fontWeight = FontWeight.SemiBold),
            color = LocalColorTheme.current.black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRecommendScreen() {
    RecommendScreen()
}