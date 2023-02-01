package com.iesfm.myfirstapplication.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iesfm.myfirstapplication.R
@Composable
fun Admin(goHome: () -> Unit,
          gofirstScreen: () -> Unit) {
    var passport by remember{ mutableStateOf("asdf")}
    var password by remember { mutableStateOf("")}
    var passwordVisible by remember { mutableStateOf(false)}
    val focusRquester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    Box(modifier = Modifier.fillMaxWidth()){
        Column( modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.Center)) {
            Text(
                text = "Login",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(CenterHorizontally),
                fontSize = 39.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            OutlinedTextField(value = passport, onValueChange = {it -> passport = it},
                modifier = Modifier
                    .padding(
                        horizontal = 16.dp
                    )
                    .fillMaxWidth()
                    .focusRequester(focusRquester),
                placeholder = {
                    Text(text = "passport")
                },
                maxLines = 1,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                )
                )
            OutlinedTextField(
                value = password, onValueChange = { it -> password = it },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .focusRequester(focusRquester),
                placeholder = {
                    Text(text = "password")
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done, keyboardType = KeyboardType.Password),
                keyboardActions = KeyboardActions(
                    onDone = {
                        goHome()
                    }
                ),
                trailingIcon = {
                    if (passwordVisible){
                        Icon(painter = painterResource(R.drawable.ic_baseline_visibility_off_24), contentDescription = stringResource(id = R.string.app_name),
                        modifier = Modifier.clickable { passwordVisible = false},
                            tint = MaterialTheme.colors.primary)
                    } else {
                        Icon(painter = painterResource(R.drawable.ic_baseline_visibility_24), contentDescription = stringResource(
                            id = R.string.app_name
                        ),
                            modifier = Modifier.clickable { passwordVisible = true },
                        tint = MaterialTheme.colors.primary
                            )
                    }
                }
            )
            Button(onClick = goHome,
            modifier = Modifier
                .padding(top = 16.dp)
                .defaultMinSize(100.dp)
                .align(CenterHorizontally)) {
                Text(text = "continue")
            }
            Text(text = "goHome", modifier = Modifier.clickable { goHome() })
            Text(text = "goFirstScreen", modifier = Modifier.clickable { gofirstScreen() })
        }
    }


}

