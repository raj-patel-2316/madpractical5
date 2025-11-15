package com.example.madpractical5

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.madpractical5.screen.Login
import com.example.madpractical5.screen.RegisterPage

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            Login(onSignUpClick = { navController.navigate("register") })
        }
        composable("register") {
            RegisterPage(onLoginClick = { navController.popBackStack() })
        }
    }
}
