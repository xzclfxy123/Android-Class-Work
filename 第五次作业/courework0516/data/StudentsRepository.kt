package com.example.compose.courework0516.data

import kotlinx.coroutines.flow.Flow


interface StudentsRepository {
    fun getAllStudentStream(): Flow<List<Student>>

    fun getStudentStream(id: Int): Flow<Student?>

    suspend fun insertStudent(student: Student)

    suspend fun deleteStudent(student: Student)

    suspend fun updateStudent(student: Student)
}