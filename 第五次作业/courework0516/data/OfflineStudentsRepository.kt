package com.example.compose.courework0516.data

import kotlinx.coroutines.flow.Flow

class OfflineStudentsRepository(private val studentDao: StudentDao): StudentsRepository {
    override fun getAllStudentStream(): Flow<List<Student>> = studentDao.getAllStudents()

    override fun getStudentStream(id: Int): Flow<Student?> = studentDao.getStudent(id)

    override suspend fun insertStudent(student: Student) {}

    override suspend fun deleteStudent(student: Student) {}

    override suspend fun updateStudent(student: Student) {}
}