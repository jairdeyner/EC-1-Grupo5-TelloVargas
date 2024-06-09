package pe.edu.idat.ec1grupo5

sealed class Router(val route: String) {
    object HOME: Router("Home")
    object WEEKLY_SALARY: Router("WeeklySalary")
    object AVERAGE: Router("Average")
    object TIME_VIEW: Router("TimeView")
    object SUM_VIEW: Router("SumView")
}