package com.oneasad.googleloginjetpackcompose.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oneasad.googleloginjetpackcompose.R
import com.oneasad.googleloginjetpackcompose.ui.theme.GoogleLoginJetpackComposeTheme

@Composable
fun LoginScreen(
    onGoogleSignInClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .fillMaxSize()
    ){

        Image(
            painter = painterResource(id = R.drawable.green_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        Image(
            painter = painterResource(id = R.drawable.loginpage_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {

            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Sign in",
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(bottom = 32.dp)
            )
            LoginBody(
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.weight(1f))
            LoginFooter(
                onGoogleSignInClick = onGoogleSignInClick,
                modifier = Modifier.padding(bottom = 20.dp)
            )
        }
    }
}

@Composable
fun LoginBody(
    modifier: Modifier = Modifier
){
    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        InputText(
            text = username,
            placeholder = "Username",
            textHandler = { username = it },
            imageVector = Icons.Default.Person,
            keyboardType = KeyboardType.Text,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        InputText(
            text = password,
            placeholder = "Password",
            textHandler = { password = it },
            imageVector = Icons.Default.Lock,
            keyboardType = KeyboardType.Password,
        )
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF03DAC5),
            ),
            modifier = Modifier.padding(16.dp)

        ) {
            Text(text = "LOGIN")
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
            ),
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Forgot password?",
                color = Color.White
            )
        }
    }
}

@Composable
fun InputText(
    text: String,
    placeholder: String,
    keyboardType: KeyboardType,
    textHandler: (String) -> Unit,
    modifier: Modifier = Modifier,
    imageVector: ImageVector
){
    TextField(
        value = text,
        onValueChange = textHandler,
        placeholder = { Text(text = placeholder, color = Color.White) },
        leadingIcon = { Icon(
            imageVector = imageVector,
            contentDescription = null,
            tint = Color.White
        ) },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0x40FFFFFF),
            unfocusedContainerColor = Color(0x40FFFFFF),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White
        ),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        visualTransformation = if (keyboardType == KeyboardType.Password) PasswordVisualTransformation() else VisualTransformation.None,
        modifier = Modifier
            .background(Color.Transparent)
            .padding(vertical = 8.dp, horizontal = 12.dp)
            .fillMaxWidth()
    )
}

@Composable
fun LoginFooter(
    modifier: Modifier = Modifier,
    onGoogleSignInClick: () -> Unit = {},
){
    Column (
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ){
        Text(
            text = "or sign in with",
            color = Color.Gray,
            modifier = Modifier.padding(16.dp)
        )
        Row {
            LogoImage( onGoogleSignInClick = onGoogleSignInClick, logo = R.drawable.google_logo )
            LogoImage( onGoogleSignInClick = onGoogleSignInClick, logo = R.drawable.facebook_logo )
            LogoImage( onGoogleSignInClick = onGoogleSignInClick, logo = R.drawable.twitter_logo )
        }
    }
}

@Composable
fun LogoImage(
    modifier: Modifier = Modifier,
    onGoogleSignInClick: () -> Unit = {},
    @DrawableRes logo: Int,
){
    Button(
        onClick = onGoogleSignInClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
        ),
        contentPadding = PaddingValues(0.dp),
        modifier = modifier
            .background(Color.Transparent)
            .wrapContentSize()
            .padding(horizontal = 8.dp)
    ) {
        Image(
            painter = painterResource(id = logo),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(40.dp)
        )
    }
}

