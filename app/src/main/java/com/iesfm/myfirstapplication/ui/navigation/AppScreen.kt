package com.iesfm.myfirstapplication.ui.navigation

import android.provider.DocumentsContract.Root

sealed class AppScreen(
    val root: String,
    val route: String
) {
    object Admin : AppScreen(
        root = "admin",
        route = "admin"
    )

    object Home : AppScreen(
        root = "home",
        route = "home"
    )

    object FirstScreen : AppScreen(
        root = "firstScreen",
        route = "firstScreen"
    )


}