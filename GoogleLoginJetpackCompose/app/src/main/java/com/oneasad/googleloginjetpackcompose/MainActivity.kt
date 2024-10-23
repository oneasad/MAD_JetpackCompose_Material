package com.oneasad.googleloginjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oneasad.googleloginjetpackcompose.myviewmodels.GoogleSignInViewModel
import com.oneasad.googleloginjetpackcompose.screens.LoginScreen
import com.oneasad.googleloginjetpackcompose.screens.ProfileEnum
import com.oneasad.googleloginjetpackcompose.screens.ProfileScreen
import com.oneasad.googleloginjetpackcompose.ui.theme.GoogleLoginJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GoogleLoginJetpackComposeTheme {
                GoogleLoginApp()
            }
        }
    }
}

@Composable
fun GoogleLoginApp(modifier: Modifier = Modifier) {

    val navController = rememberNavController()
    val context = LocalContext.current
    val googleSignInViewModel = GoogleSignInViewModel()

    NavHost(navController = navController, startDestination = ProfileEnum.home.name) {

        composable(route = ProfileEnum.home.name) {
            LoginScreen(
                onGoogleSignInClick =
                { googleSignInViewModel.handleGoogleSignIn(context,navController) },
                modifier = modifier
            )
        }

        composable(route = ProfileEnum.profile.name) {
            ProfileScreen(
                googleSignInViewModel = googleSignInViewModel,
                onGoogleSignOutClick = { googleSignInViewModel.signOut(navController) },
                modifier = modifier
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GoogleLoginJetpackComposeTheme  {
        GoogleLoginApp()
    }
}