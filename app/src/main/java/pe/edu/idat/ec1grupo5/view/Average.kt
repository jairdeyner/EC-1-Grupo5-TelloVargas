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
fun Average(navController: NavController) {
    var p1 by rememberSaveable {
        mutableStateOf("")
    }

    var p2 by rememberSaveable {
        mutableStateOf("")
    }

    var p3 by rememberSaveable {
        mutableStateOf("")
    }

    var p4 by rememberSaveable {
        mutableStateOf("")
    }

    var average by rememberSaveable {
        mutableStateOf("")
    }

    var deleted by rememberSaveable {
        mutableStateOf("")
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(text = "Promedio de Notas") },
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
                value = p1,
                onValueChange = { p1 = it},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Práctica 1")},
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.size(16.dp))

            OutlinedTextField(
                value = p2,
                onValueChange = { p2 = it},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Práctica 2")},
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.size(16.dp))

            OutlinedTextField(
                value = p3,
                onValueChange = { p3 = it},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Práctica 3")},
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.size(16.dp))

            OutlinedTextField(
                value = p4,
                onValueChange = { p4 = it},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Práctica 4")},
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.size(16.dp))

            Button(
                onClick = {
                    average = "El promedio es ${getAverage(p1.toDouble(), p2.toDouble(), p3.toDouble(), p4.toDouble()).average}"
                    deleted = "Nota eliminada: ${getAverage(p1.toDouble(), p2.toDouble(), p3.toDouble(), p4.toDouble()).deleted}"
                }
            ) {
                Text(text = "CALCULAR")
            }

            Spacer(modifier = Modifier.size(16.dp))

            Text(
                text = deleted,
                style = TextStyle(fontWeight = FontWeight.Bold, color = Color.DarkGray)
            )

            Spacer(modifier = Modifier.size(16.dp))

            Text(
                text = average,
                style = TextStyle(fontWeight = FontWeight.Bold, color = Color.DarkGray)
            )
        }
    }
}

data class Nota(val deleted: Double, val average: Double)

fun getAverage(p1: Double, p2: Double, p3: Double, p4: Double): Nota {
    val gradedScoreList = arrayOf<Double>(p1, p2, p3, p4)

    val deleted: Double = gradedScoreList.min()

    val average: Double = gradedScoreList
        .filter { score -> score != deleted }.average()

    return Nota(deleted = deleted,average = average)
}