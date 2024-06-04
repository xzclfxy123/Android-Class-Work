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

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.compose.courework0516.data.Student
import com.example.compose.courework0516.data.StudentsRepository
import java.text.NumberFormat

/**
 * ViewModel to validate and insert items in the Room database.
 */
class StudentEntryViewModel(private val studentsRepository: StudentsRepository) : ViewModel() {

    /**
     * Holds current item ui state
     */
    var studentUiState by mutableStateOf(StudentUiState())
        private set

    /**
     * Updates the [studentUiState] with the value provided in the argument. This method also triggers
     * a validation for input values.
     */
    fun updateUiState(studnetDetails: StudentDetails) {
        studentUiState =
            StudentUiState(studentDetails = studnetDetails, isEntryValid = validateInput(studnetDetails))
    }

    suspend fun saveStudent() {
        if (validateInput()) {
            studentsRepository.insertStudent(studentUiState.studentDetails.toStudent())
        }
    }

    private fun validateInput(uiState: StudentDetails = studentUiState.studentDetails): Boolean {
        return with(uiState) {
            name.isNotBlank()
        }
    }
}

/**
 * Represents Ui State for an Student.
 */
data class StudentUiState(
    val studentDetails: StudentDetails = StudentDetails(),
    val isEntryValid: Boolean = false
)

data class StudentDetails(
    val id: Int? = 0,
    val name: String = "",

    )

/**
 * Extension function to convert [StudentDetails] to [Student]. If the value of [StudentDetails.price] is
 * not a valid [Double], then the price will be set to 0.0. Similarly if the value of
 * [StudentDetails.quantity] is not a valid [Int], then the quantity will be set to 0
 */
fun StudentDetails.toStudent(): Student = Student(
    id = id,
    sName = name,

)

fun Student.formatedPrice(): String {
    return NumberFormat.getCurrencyInstance().format(sName)
}

/**
 * Extension function to convert [Student] to [StudentUiState]
 */
fun Student.toStudentUiState(isEntryValid: Boolean = false): StudentUiState = StudentUiState(
    studentDetails = this.toStudentDetails(),
    isEntryValid = isEntryValid
)

/**
 * Extension function to convert [Student] to [StudentDetails]
 */
fun Student.toStudentDetails(): StudentDetails = StudentDetails(
    id = id,
    name = sName,
)
