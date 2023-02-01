package com.iesfm.myfirstapplication.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Home(goFirstScreen: () -> Unit,
         goAdmin: () -> Unit) {
    Column() {
        Text(text = "Home")
        Text(text = "goAdmin", modifier = Modifier.clickable { goAdmin() })
        Text(text = "goFirstScreen", modifier = Modifier.clickable { goFirstScreen() })
    }

}