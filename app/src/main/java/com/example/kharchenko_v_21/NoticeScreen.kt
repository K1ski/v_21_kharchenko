package com.example.kharchenko_v_21

import androidx.compose.foundation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun NoticeScreen(navController: NavController) {
    val White = Color(0xFFFFFFFF)
    val LightGray = Color(0xFFF7F7F7)
    val DarkText = Color(0xFF2E2E2E)
    val PrimaryGreen = Color(0xFF04A828)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null,
                    tint = PrimaryGreen,
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { navController.popBackStack() }
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "История",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkText
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            HistoryItem(title = "Текст", content = "Сегодня будет Урок по Git")
            HistoryItem(title = "URL", content = "https://ez-gif.com/cut")
            HistoryItem(title = "Телефон", content = "+7 (383) 200-00-00")

            Spacer(modifier = Modifier.height(24.dp))

            var checked1 by remember { mutableStateOf(true) }
            var checked2 by remember { mutableStateOf(true) }
            var checked3 by remember { mutableStateOf(false) }

            CheckboxItem(text = "Запомнить мои данные", checked = checked1, onCheckedChange = { checked1 = it })
            CheckboxItem(text = "Сохранять мои действия", checked = checked2, onCheckedChange = { checked2 = it })
            CheckboxItem(text = "Вести статистику сканирований", checked = checked3, onCheckedChange = { checked3 = it })
        }
    }
}

@Composable
fun HistoryItem(title: String, content: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF7F7F7), shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text(text = title, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        Text(text = content, fontSize = 14.sp, color = Color.Gray)
    }
    Spacer(modifier = Modifier.height(12.dp))
}

@Composable
fun CheckboxItem(text: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = text, fontSize = 16.sp, color = Color.Black, modifier = Modifier.weight(1f))
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(checkedColor = Color(0xFF04A828))
        )
    }
}