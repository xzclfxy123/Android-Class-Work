/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.compose.courework0516.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.compose.courework0516.ui.home.HomeDestination
import com.example.compose.courework0516.ui.home.HomeScreen
import com.example.compose.courework0516.ui.student.StudentDetailsDestination
import com.example.compose.courework0516.ui.student.StudentDetailsScreen
import com.example.compose.courework0516.ui.student.StudentEditDestination
import com.example.compose.courework0516.ui.student.StudentEditScreen
import com.example.compose.courework0516.ui.student.StudentEntryDestination
import com.example.compose.courework0516.ui.student.StudentEntryScreen

/**
 * Provides Navigation graph for the application.
 */
@Composable
fun InventoryNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController, startDestination = HomeDestination.route, modifier = modifier
    ) {
        composable(route = HomeDestination.route) {
            HomeScreen(
                navigateToStudentEntry = { navController.navigate(StudentEntryDestination.route) },
                navigateToStudentUpdate = {
                    navController.navigate("${StudentDetailsDestination.route}/${it}")
                })
        }
        composable(route = StudentEntryDestination.route) {
            StudentEntryScreen(navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() })
        }
        composable(
            route = StudentDetailsDestination.routeWithArgs,
            arguments = listOf(navArgument(StudentDetailsDestination.studentIdArg) {
                type = NavType.IntType
            })
        ) {
            StudentDetailsScreen(
                navigateToEditItem =
                {
                    navController.navigate("${StudentEditDestination.route}/$it")
                },
                navigateBack = { navController.navigateUp() })
        }
        composable(
            route = StudentEditDestination.routeWithArgs,
            arguments = listOf(navArgument(StudentEditDestination.studentIdArg) {
                type = NavType.IntType
            })
        ) {
            StudentEditScreen(navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() })
        }
    }
}
