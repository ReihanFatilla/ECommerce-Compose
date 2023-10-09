package com.trawlbens.reift.e_commerce.utils

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.animations.defaults.RootNavGraphDefaultAnimations
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import com.ramcosta.composedestinations.spec.NavHostEngine

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialNavigationApi::class)
@Composable
fun generateCustomNavHostEngine(): NavHostEngine {
    return rememberAnimatedNavHostEngine(
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
}