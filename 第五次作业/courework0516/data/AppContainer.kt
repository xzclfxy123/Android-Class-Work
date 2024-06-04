package com.example.compose.courework0516.data

import android.content.Context

interface AppContainer{
    val studentsRepository:StudentsRepository
}

class AppDataContainer(private val context: Context):AppContainer{
    override val studentsRepository: StudentsRepository by lazy {
        OfflineStudentsRepository(StudentDatabase.getDatabase(context).studentDao())
    }
}