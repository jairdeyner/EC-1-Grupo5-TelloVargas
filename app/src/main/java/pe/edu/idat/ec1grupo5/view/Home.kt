package pe.edu.idat.ec1grupo5.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import pe.edu.idat.ec1grupo5.Router

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Home(
    navController: NavController
) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                navController.navigate(Router.WEEKLY_SALARY.route)
            }) {
                Text(text = "1. Salario Semanal")
            }

            Button(onClick = {
                navController.navigate(Router.AVERAGE.route)
            }) {
                Text(text = "2. Promedio Prácticas")
            }

            Button(onClick = {
                navController.navigate(Router.TIME_VIEW.route)
            }) {
                Text(text = "3. Tiempo en Minutos")
            }

            Button(onClick = {
                navController.navigate(Router.SUM_VIEW.route)
            }) {
                Text(text = "4. Suma en Serie")
            }
        }
    }
}