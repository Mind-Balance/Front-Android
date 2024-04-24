package com.salvamoreno.mindbalance.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.salvamoreno.mindbalance.ui.changeForgottenPass.ChangeForgottenPassScreen
import com.salvamoreno.mindbalance.ui.changeForgottenPass.ChangeForgottenPassViewModel
import com.salvamoreno.mindbalance.ui.passForgotten.PassForgottenScreen
import com.salvamoreno.mindbalance.ui.passForgotten.PassForgottenViewModel
import com.salvamoreno.mindbalance.ui.successChangeForgottenPass.SuccessChangeForgottenPassScreen

@Composable
fun MindBalanceAppNavigation(
    navController: NavHostController,
    passForgottenViewModel: PassForgottenViewModel,
    changeForgottenPassViewModel: ChangeForgottenPassViewModel,
) {
    NavHost(navController = navController, startDestination = Routes.PassForgottenScreen.route) {
        // PASSWORD FORGOTTEN SCREEN
        composable(Routes.PassForgottenScreen.route) {
            PassForgottenScreen(
                passForgottenViewModel = passForgottenViewModel,
                onBack = {
                    println("navController.navigate(Routes.LOGIN.route)")
                }
            ) {
                navController.navigate(Routes.ChangeForgottenPass.route)
            }
        }
        // CHANGE FORGOTTEN PASSWORD SCREEN
        composable(Routes.ChangeForgottenPass.route) {
            ChangeForgottenPassScreen(
                changeForgottenPassViewModel = changeForgottenPassViewModel,
                onBack = {
                    navController.navigate(Routes.PassForgottenScreen.route)
                }
            ) {
                navController.navigate(Routes.SuccessChangeForgottenPass.route)
            }
        }
        // SUCCESS CHANGE FORGOTTEN PASSWORD SCREEN
        composable(Routes.SuccessChangeForgottenPass.route) {
            SuccessChangeForgottenPassScreen {
                println("navController.navigate(Routes.LOGIN.route)")
            }
        }
    }
}