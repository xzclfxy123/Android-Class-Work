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

package com.example.compose.courework0516.ui.student

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

/**
 * ViewModel to retrieve, update and delete an item from the [StudnetsRepository]'s data source.
 */
class StudentDetailsViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val studentId: Int = checkNotNull(savedStateHandle[StudentDetailsDestination.studentIdArg])

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

/**
 * UI state for StudentDetailsScreen
 */
data class StudentDetailsUiState(
    val outOfStock: Boolean = true,
    val studentDetails: StudentDetails = StudentDetails()
)
