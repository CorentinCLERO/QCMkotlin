package com.example.qcm

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Response(navController: NavHostController, ResourceManagement: ResourceManagement.Companion){
    if (ResourceManagement.getStateresponse()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
        ) {
            Text(
                text = stringResource(ResourceManagement.getQuestion()),
                modifier = Modifier
                    .clickable {
                        navController.navigate(Screen.ListQCM.itineraire)
                    }
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(5.dp)
            )
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "Bravo",
                modifier = Modifier
                    .clickable {
                        ResourceManagement.setCurrentIndex(0)
                        navController.navigate(Screen.ListQCM.itineraire)
                    }
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(5.dp)
            )
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
        ) {
            Text(
                text = stringResource(ResourceManagement.getQuestion()),
                modifier = Modifier
                    .clickable {
                        navController.navigate(Screen.ListQCM.itineraire)
                    }
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(5.dp)
            )
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "Mauvaise réponse",
                modifier = Modifier
                    .clickable {
                        navController.navigate(Screen.QuestionScreen.itineraire)
                    }
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(5.dp)
            )
        }
    }
}