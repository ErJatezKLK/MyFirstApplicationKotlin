package com.iesfm.myfirstapplication.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FirstScreen(goHome: () -> Unit, goAdmin: () -> Unit) {
    Column(){
        Text(text = "FirstScreen")
        Text(text = "goHome", modifier = Modifier.clickable { goHome() })
        Text(text = "goAdmin", modifier = Modifier.clickable { goAdmin() })
    }

}