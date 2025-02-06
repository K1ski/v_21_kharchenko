package com.example.kharchenko_v_21

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigator(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("personal_area") { PersonalAreaScreen(navController) }
        composable("notice") { NoticeScreen(navController) }
    }
}