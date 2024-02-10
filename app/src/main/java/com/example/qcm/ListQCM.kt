package com.example.qcm

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun ListQCM(navController: NavHostController, ResourceManagement: ResourceManagement.Companion, viewModel: QuestionVisibilityViewModel) {
    Column {
        if (viewModel.question1Visible.value) {
            LignQuestion(
                navController,
                1,
                viewModel.question1Visible,
                ResourceManagement
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        if (viewModel.question2Visible.value) {
            LignQuestion(
                navController,
                2,
                viewModel.question2Visible,
                ResourceManagement
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        if (viewModel.question3Visible.value) {
            LignQuestion(
                navController,
                3,
                viewModel.question3Visible,
                ResourceManagement
            )
        }
    }
}


@Composable
fun LignQuestion(
    navController: NavHostController,
    questionNumber: Int,
    isVisible: MutableState<Boolean>,
    ResourceManagement: ResourceManagement.Companion
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 90.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(ResourceManagement.getQuestionTitle(questionNumber)),
            modifier = Modifier
                .clickable{
                navController.navigate(Screen.QuestionScreen.itineraire)
                ResourceManagement.setCurrentIndex(questionNumber)
            }
                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                .padding(5.dp)
        )
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .clickable{
                    isVisible.value = false
                }
                .align(Alignment.CenterVertically)
                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                .padding(5.dp)
        )
    }
}
