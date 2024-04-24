package com.salvamoreno.mindbalance.ui.navigation

sealed class Routes(val route: String) {
    object PassForgottenScreen : Routes("passForgottenScreen")
    object ChangeForgottenPass : Routes("changeForgottenPass")
    object SuccessChangeForgottenPass : Routes("successChangeForgottenPass")
}