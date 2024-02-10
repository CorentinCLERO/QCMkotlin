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
fun Question(navController: NavHostController, ResourceManagement: ResourceManagement.Companion) {
    fun checkAnswer(selectedIndex: Int): Boolean {
        return ResourceManagement.getResponse(selectedIndex) == ResourceManagement.getResponse(0)
    }

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
        for (i in 1..4) {
            Text(
                text = stringResource(ResourceManagement.getResponse(i)),
                modifier = Modifier
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(5.dp)
                    .clickable {
                        if (checkAnswer(i)) {
                            ResourceManagement.setStateresponse(true)
                        } else {
                            ResourceManagement.setStateresponse(false)
                        }
                        navController.navigate(Screen.ResponseScreen.itineraire)
                    }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

