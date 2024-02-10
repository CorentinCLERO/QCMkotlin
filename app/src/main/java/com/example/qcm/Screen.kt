package com.example.qcm

sealed class Screen(val itineraire : String) {
    object ListQCM : Screen("list_qcm")
    object QuestionScreen : Screen("question_screen")
    object ResponseScreen : Screen("response_screen")
}