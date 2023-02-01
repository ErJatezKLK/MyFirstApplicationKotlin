package com.iesfm.myfirstapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.iesfm.myfirstapplication.ui.screens.Admin
import com.iesfm.myfirstapplication.ui.screens.FirstScreen
import com.iesfm.myfirstapplication.ui.screens.Home

@Composable
fun AppNavigation(navController: NavHostController){
    
    NavHost(
        navController = navController, 
        startDestination = AppScreen.Admin.route,
    ){
        composable(route = AppScreen.Admin.route){
            Admin(
                goHome = {
                    navController.navigate(AppScreen.Home.route)
                }, gofirstScreen ={
                    navController.popBackStack()
                    navController.navigate(AppScreen.FirstScreen.route)
                }
            ) 
        }
        composable(route = AppScreen.Home.route){
            Home(
                goFirstScreen = {
                    navController.navigate(AppScreen.FirstScreen.route)
                }, goAdmin = {
                    navController.navigate(AppScreen.Admin.route)
                }
            ) 
        }
        composable(route = AppScreen.FirstScreen.route){
            FirstScreen(
                goHome = {
                    navController.navigate(AppScreen.Home.route)
                }, goAdmin = {
                    navController.navigate(AppScreen.Admin.route)
                }
            )
        }
    }
}