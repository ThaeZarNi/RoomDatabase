package com.example.project_six.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.project_six.dao.BookDAO
import com.example.project_six.entity.BookEntity

@Database(entities = [(BookEntity::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDAO
}