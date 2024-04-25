package com.salvamoreno.mindbalance.ui.navigation

sealed class Routes(val route: String) {
    object LoginScreen : Routes("loginScreen")
    object ChangePasswordScreen : Routes("changePasswordScreen")
    object SuccessChangePassword : Routes("successChangePassword")
    object OnboardingScreen : Routes("onboardingScreen")
    object PassForgottenScreen : Routes("passForgottenScreen")
    object ChangeForgottenPass : Routes("changeForgottenPass")
    object SuccessChangeForgottenPass : Routes("successChangeForgottenPass")
    object HomeScreen : Routes("homeScreen")
}