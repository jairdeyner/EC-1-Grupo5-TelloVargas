package pe.edu.idat.ec1grupo5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.idat.ec1grupo5.ui.theme.EC1Grupo5Theme
import pe.edu.idat.ec1grupo5.view.Average
import pe.edu.idat.ec1grupo5.view.Home
import pe.edu.idat.ec1grupo5.view.SumView
import pe.edu.idat.ec1grupo5.view.WeeklySalary
import pe.edu.idat.ec1grupo5.view.TimeView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EC1Grupo5Theme {
                val navController: NavHostController = rememberNavController()

                NavHost(navController = navController, startDestination = Router.HOME.route) {
                    composable(Router.HOME.route) {
                        Home( navController = navController)
                    }

                    composable(Router.WEEKLY_SALARY.route) {
                        WeeklySalary(navController = navController)
                    }

                    composable(Router.AVERAGE.route) {
                        Average(navController = navController)
                    }

                    composable(Router.TIME_VIEW.route) {
                        TimeView(navController = navController)
                    }

                    composable(Router.SUM_VIEW.route) {
                        SumView(navController = navController)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EC1Grupo5Theme {

    }
}