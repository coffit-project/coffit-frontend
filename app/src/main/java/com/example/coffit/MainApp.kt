package com.example.coffit

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.design.theme.ThemeProvider
import com.example.home.HomeScreen
import com.example.login.LoginScreen
import kotlinx.coroutines.delay

@Composable
fun MainApp(
    viewModel: MainViewModel,
) {
    val navController = rememberNavController()
//    val isLoggedIn by viewModel.isLoggedInState.collectAsState()

    ThemeProvider {
        NavHost(
            navController = navController,
            startDestination = NavigationRoute.Splash.route,
            modifier = Modifier.fillMaxSize(),
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None },
            popEnterTransition = { EnterTransition.None },
            popExitTransition = { ExitTransition.None }
        ) {
            composable(NavigationRoute.Splash.route) {
                LaunchedEffect(Unit) {
                    delay(2000)
                    navController.navigate(NavigationRoute.Login.route) {
                        popUpTo(NavigationRoute.Splash.route) { inclusive = true }
                    }
                }
                SplashScreen()
            }

            composable(NavigationRoute.Login.route) {
                FinishHandler()
                LoginScreen()
            }

            composable(NavigationRoute.Home.route) {
                FinishHandler()
                HomeScreen()
            }
        }

    }

//    // 로그인 상태에 따라 네비게이션 처리
//    LaunchedEffect(key1 = isLoggedIn) {
//        isLoggedIn?.let { loggedIn ->
//            val targetRoute = if (loggedIn) NavigationRoute.Home.route else NavigationRoute.Login.route
//            navigator.navigate(targetRoute) {
//                popUpTo(navigator.graph.startDestinationId) { inclusive = false }
//            }
//        } ?: navigator.popBackStack(
//            destinationId = navigator.graph.startDestinationId,
//            inclusive = false
//        )
//    }
}

@Composable
private fun FinishHandler() {
    val context = LocalContext.current
    val activity = remember(context) { context.findActivity() }
    var lastBackPressed by remember { mutableLongStateOf(0L) }

    BackHandler {
        val now = System.currentTimeMillis()
        if (now - lastBackPressed < 2000L) {
            activity?.finish()
        } else {
            Toast.makeText(context, "뒤로 한 번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show()
            lastBackPressed = now
        }
    }
}

// Context → Activity 확장 함수
fun android.content.Context.findActivity(): android.app.Activity? {
    var ctx = this
    while (ctx is android.content.ContextWrapper) {
        if (ctx is android.app.Activity) return ctx
        ctx = ctx.baseContext
    }
    return null
}

// NavigationRoute 정의 (필요한 라우트만 포함)
enum class NavigationRoute(val route: String) {
    Splash("splash"),
    Login("login"),
    Home("home")
}

// setNavGraph 확장 함수
fun NavigationRoute.setNavGraph(
    content: @Composable () -> Unit
): NavGraphBuilder.() -> Unit = {
    composable(this@setNavGraph.route) {
        content()
    }
}