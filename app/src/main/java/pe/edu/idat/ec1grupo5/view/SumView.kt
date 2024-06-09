package pe.edu.idat.ec1grupo5.view

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SumView(navController: NavController) {
    var numberLimit by rememberSaveable {
        mutableStateOf("")
    }

    var result by rememberSaveable {
        mutableStateOf("")
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(text = "Suma en Serie") },
                navigationIcon = {
                    Icon(
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        },
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = ""
                    )
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.size(100.dp))

            OutlinedTextField(
                value = numberLimit,
                onValueChange = { numberLimit = it},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Numero límite")},
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.size(16.dp))

            Button(
                onClick = {
                    result = "La suma del 1 al $numberLimit es ${getSum(numberLimit.toInt())}"
                }
            ) {
                Text(text = "CALCULAR")
            }

            Spacer(modifier = Modifier.size(16.dp))

            Text(
                text = result,
                style = TextStyle(fontWeight = FontWeight.Bold, color = Color.DarkGray)
            )
        }
    }
}

fun getSum(number: Int): Int = (1..number).sum()