package com.example.compose.courework0516.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class StudentDatabase : RoomDatabase(){

    abstract fun studentDao(): StudentDao

    companion object{
        @Volatile
        private var Instance: StudentDatabase? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context): StudentDatabase {
            return Instance ?: synchronized(this){
                Room.databaseBuilder(context, StudentDatabase::class.java, "student_data")
                    .build().also { Instance = it}
            }
        }
    }
}
