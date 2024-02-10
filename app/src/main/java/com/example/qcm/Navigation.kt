package com.example.qcm

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class QuestionVisibilityViewModel : ViewModel() {
    val question1Visible = mutableStateOf(true)
    val question2Visible = mutableStateOf(true)
    val question3Visible = mutableStateOf(true)
}

@Composable
fun Navigation(ResourceManagement: ResourceManagement.Companion){
    val navController = rememberNavController()
    val viewModel = remember { QuestionVisibilityViewModel() }

    NavHost(navController, startDestination = Screen.ListQCM.itineraire) {
        composable(route = Screen.ListQCM.itineraire) {
            ListQCM(navController, ResourceManagement, viewModel)
        }
        composable(route = Screen.QuestionScreen.itineraire) {
            Question(navController, ResourceManagement)
        }
        composable(route = Screen.ResponseScreen.itineraire) {
            Response(navController, ResourceManagement)
        }
    }
}