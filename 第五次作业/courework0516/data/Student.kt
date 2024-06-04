package com.example.compose.courework0516.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_data")
data class Student(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,

    @ColumnInfo(name = "sName")
    val sName : String,
)