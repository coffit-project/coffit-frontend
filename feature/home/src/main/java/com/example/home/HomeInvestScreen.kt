package com.example.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.design.theme.LocalColorTheme

data class InvestCategory(
    val title: String,
    val subtitle: String
)

@Composable
fun HomeInvestScreen() {
    val investCategories = listOf(
        InvestCategory("ESG · 친환경", "전기차, 태양광, 수소 등 지속가능 산업"),
        InvestCategory("IT · AI", "반도체, 클라우드, 인공지능"),
        InvestCategory("엔터 · 게임", "K-POP, 콘텐츠, 게임, 메타버스"),
        InvestCategory("소비재 · 유통", "뷰티, 식음료, 커머스, 리오프닝"),
        InvestCategory("금융 · 핀테크", "모바일 결제, 인터넷은행, 금융IT"),
        InvestCategory("헬스케어 · 바이오", "제약, 의료기기, 디지털 헬스"),
        InvestCategory("미래 모빌리티", "자율주행, UAM, 차량용 반도체"),
        InvestCategory("건설 · 인프라", "부동산, SOC, 스마트시티"),
        InvestCategory("교육 · 소프트웨어", "에듀테크, SaaS, 자동차 소프트웨어"),
    )
    val categories = remember { investCategories }
    var selectedIndexes by remember { mutableStateOf(listOf<Int>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LocalColorTheme.current.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "관심 있는 투자 분야를\n3가지 선택해주세요.",
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Medium, lineHeight = 29.sp),
            color = LocalColorTheme.current.black,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 76.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        categories.forEachIndexed { idx, category ->
            InvestCategoryItem(
                category = category,
                selected = idx in selectedIndexes,
                onClick = {
                    selectedIndexes = if (idx in selectedIndexes) {
                        selectedIndexes - idx
                    } else {
                        if (selectedIndexes.size < 3) selectedIndexes + idx else selectedIndexes
                    }
                },
                modifier = Modifier.padding(top = if (idx == 0) 0.dp else 15.dp)
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .clip(RoundedCornerShape(28.dp))
                .background(LocalColorTheme.current.maincolor[200])
                .padding(top = 13.dp, start = 126.dp, end = 125.dp, bottom = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "선택 완료",
                style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.SemiBold),
                color = LocalColorTheme.current.white
            )
        }
    }
}

@Composable
fun InvestCategoryItem(
    category: InvestCategory,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(28.dp),
        border = BorderStroke(
            width = if (selected) 3.dp else 1.dp,
            color = LocalColorTheme.current.maincolor[200]
        ),
        color = LocalColorTheme.current.background,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 13.dp)
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .background(LocalColorTheme.current.white)
                .padding(top = 9.dp, start = 14.dp, end = 14.dp, bottom = 6.dp)
        ) {
            Text(
                text = category.title,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = LocalColorTheme.current.black,
                    lineHeight = 21.sp
                )
            )

            Text(
                text = category.subtitle,
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = LocalColorTheme.current.gray[400],
                    lineHeight = 20.sp
                ),
                modifier = Modifier.padding(top = 4.dp, start = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeInvestScreen() {
    HomeInvestScreen()
}