package com.example.kharchenko_v_21

import android.content.ContentValues
import androidx.compose.foundation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun LoginScreen(navController: NavController) {
    val White = Color(0xFFFFFFFF)
    val DarkText = Color(0xFF2E2E2E)
    val PrimaryGreen = Color(0xFF04A828)

    var loginValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }
    val context = LocalContext.current
    val dbHelper = Database(context, "DATABASE1")


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.login),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f, fill = false)
                    .padding(top = 20.dp),
                alignment = Alignment.Center
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = loginValue,
                    onValueChange = { loginValue = it },
                    label = { Text("Логин", color = DarkText) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = passwordValue,
                    onValueChange = { passwordValue = it },
                    label = { Text("Пароль", color = DarkText) },
                    singleLine = true,
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Button(
                onClick = {

                        val db = dbHelper.writableDatabase

                        val contentValues = ContentValues().apply {
                            put(Database.COLUMN_LOGIN, loginValue)
                            put(Database.COLUMN_PASS, passwordValue)
                        }

                        db.insert(Database.TABLE, null, contentValues)

                        navController.navigate("personal_area")

                },
                colors = buttonColors(containerColor = PrimaryGreen),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
            ) {
                Text(text = "Авторизоваться", fontSize = 16.sp, color = White)
            }
        }
    }
}
