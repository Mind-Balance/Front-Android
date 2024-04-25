package com.salvamoreno.mindbalance.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.salvamoreno.mindbalance.ui.changeForgottenPass.ChangeForgottenPassScreen
import com.salvamoreno.mindbalance.ui.changeForgottenPass.ChangeForgottenPassViewModel
import com.salvamoreno.mindbalance.ui.changePassword.ChangePasswordScreen
import com.salvamoreno.mindbalance.ui.changePassword.ChangePasswordViewModel
import com.salvamoreno.mindbalance.ui.home.HomeScreen
import com.salvamoreno.mindbalance.ui.login.LoginScreen
import com.salvamoreno.mindbalance.ui.login.LoginViewModel
import com.salvamoreno.mindbalance.ui.onboarding.OnboardingScreen
import com.salvamoreno.mindbalance.ui.passForgotten.PassForgottenScreen
import com.salvamoreno.mindbalance.ui.passForgotten.PassForgottenViewModel
import com.salvamoreno.mindbalance.ui.successChangeForgottenPass.SuccessChangeForgottenPassScreen
import com.salvamoreno.mindbalance.ui.successChangePassword.SuccessChangePasswordScreen

@Composable
fun MindBalanceAppNavigation(
    navController: NavHostController,
    loginViewModel: LoginViewModel,
    changePasswordViewModel: ChangePasswordViewModel,
    passForgottenViewModel: PassForgottenViewModel,
    changeForgottenPassViewModel: ChangeForgottenPassViewModel,
) {
    NavHost(navController = navController, startDestination = Routes.LoginScreen.route) {
        // LOGIN SCREEN
        composable(Routes.LoginScreen.route) {
            LoginScreen(
                loginViewModel = loginViewModel,
                onChangeForgottenPassword = {
                    navController.navigate(Routes.PassForgottenScreen.route)
                },
                onAccessTokenEmpty = {
                    navController.navigate(Routes.ChangePasswordScreen.route)
                }
            ) {
                navController.navigate(Routes.HomeScreen.route)
            }
        }
        // CHANGE PASSWORD SCREEN
        composable(Routes.ChangePasswordScreen.route) {
            ChangePasswordScreen(changePasswordViewModel = changePasswordViewModel) {
                navController.navigate(Routes.SuccessChangePassword.route)
            }
        }
        // SUCCESS CHANGE PASSWORD SCREEN
        composable(Routes.SuccessChangePassword.route) {
            SuccessChangePasswordScreen {
                navController.navigate(Routes.OnboardingScreen.route)
            }
        }
        // ONBOARDING SCREEN
        composable(Routes.OnboardingScreen.route) {
            OnboardingScreen()
        }
        // PASSWORD FORGOTTEN SCREEN
        composable(Routes.PassForgottenScreen.route) {
            PassForgottenScreen(
                passForgottenViewModel = passForgottenViewModel,
                onBack = {
                    navController.navigate(Routes.LoginScreen.route)
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
                navController.navigate(Routes.LoginScreen.route)
            }
        }
        // HOME SCREEN
        composable(Routes.HomeScreen.route) {
            HomeScreen()
        }
    }
}