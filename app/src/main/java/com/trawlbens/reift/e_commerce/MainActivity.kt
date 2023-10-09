package com.trawlbens.reift.e_commerce

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.defaults.NestedNavGraphDefaultAnimations
import com.ramcosta.composedestinations.animations.defaults.RootNavGraphDefaultAnimations
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.rememberNavHostEngine
import com.ramcosta.composedestinations.spec.NavHostEngine
import com.trawlbens.reift.e_commerce.presentation.NavGraphs
import com.trawlbens.reift.e_commerce.presentation.home.HomeScreen
import com.trawlbens.reift.e_commerce.ui.theme.ECommerceTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialNavigationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ECommerceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navHostEngine = rememberAnimatedNavHostEngine(
                        navHostContentAlignment = Alignment.TopCenter,
                        rootDefaultAnimations = RootNavGraphDefaultAnimations(
                            enterTransition = { slideInHorizontally(animationSpec = tween(500), initialOffsetX = { it }) },
                            exitTransition = { slideOutHorizontally(animationSpec = tween(500)) },
                            popExitTransition = {
                                slideOutOfContainer(
                                    animationSpec = tween(500),
                                    towards = AnimatedContentScope.SlideDirection.End
                                )
                            },
                            popEnterTransition = {
                                slideIntoContainer(
                                    animationSpec = tween(500),
                                    towards = AnimatedContentScope.SlideDirection.End,
                                    initialOffset = { it/2 }
                                )
                            }
                        )
                    )

                    DestinationsNavHost(
                        navGraph = NavGraphs.root,
                        engine = navHostEngine,
                        navController = rememberAnimatedNavController()
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun GreetingPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val navController = rememberNavController()
//        HomeScreen()
    }
}