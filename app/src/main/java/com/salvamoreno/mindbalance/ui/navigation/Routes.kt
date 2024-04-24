package com.salvamoreno.mindbalance.ui.navigation

sealed class Routes(val route: String) {
    object PassForgottenScreen : Routes("passForgottenScreen")
    object ChangeForgottenPass : Routes("changeForgottenPass")
    object CharacterDetailScreen : Routes("characterDetailScreen/{characterId}") {
        fun createRoute(characterId: Long) = "characterDetailScreen/$characterId"
    }
}