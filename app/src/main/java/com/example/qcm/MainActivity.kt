package com.example.qcm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.qcm.ui.theme.QCMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QCMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier,
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingHeader()
                    GreetingBody(Modifier)
                }
            }
        }
    }
}

@Composable
fun GreetingHeader(modifier: Modifier = Modifier) {
    val textTitle = R.string.app_name
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Yellow)
            .height(50.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(id = textTitle),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun GreetingBody(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Navigation(ResourceManagement)
    }
}

class ResourceManagement {
    companion object {
        private var currentIndex = 0
        private var stateResponse = true

        fun getQuestionTitle(index: Int = currentIndex): Int {
            return when (index) {
                1 -> R.string.qtitle_1
                2 -> R.string.qtitle_2
                3 -> R.string.qtitle_3
                else -> R.string.app_name
            }
        }

        fun getQuestion(index: Int = currentIndex): Int {
            return when (index) {
                1 -> R.string.qquestion_1
                2 -> R.string.qquestion_2
                3 -> R.string.qquestion_3
                else -> 0 // Mettez une valeur par défaut ou gérez l'erreur selon vos besoins
            }
        }

        fun getResponse(responseIndex: Int, index: Int = currentIndex): Int {
            return when (index) {
                1 -> {
                    when (responseIndex) {
                        1 -> R.string.qresponse1_1
                        2 -> R.string.qresponse2_1
                        3 -> R.string.qresponse3_1
                        4 -> R.string.qresponse4_1
                        else -> R.string.qresponse3_1
                    }
                }
                2 -> {
                    when (responseIndex) {
                        1 -> R.string.qresponse1_2
                        2 -> R.string.qresponse2_2
                        3 -> R.string.qresponse3_2
                        4 -> R.string.qresponse4_2
                        else -> R.string.qresponse2_2
                    }
                }
                3 -> {
                    when (responseIndex) {
                        1 -> R.string.qresponse1_3
                        2 -> R.string.qresponse2_3
                        3 -> R.string.qresponse3_3
                        4 -> R.string.qresponse4_3
                        else -> R.string.qresponse2_3
                    }
                }
                else -> 0 // Mettez une valeur par défaut ou gérez l'erreur selon vos besoins
            }
        }

        fun setCurrentIndex(index: Int) {
            currentIndex = index
        }

        fun setStateresponse(state: Boolean) {
            stateResponse = state
        }

        fun getStateresponse(): Boolean {
            return stateResponse
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    QCMTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier,
            color = MaterialTheme.colorScheme.background
        ) {
            GreetingHeader()
            GreetingBody(Modifier)
        }
    }
}