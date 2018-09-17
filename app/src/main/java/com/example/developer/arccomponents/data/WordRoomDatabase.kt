package com.example.developer.arccomponents.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.developer.arccomponents.Daos.WordDao
import com.example.developer.arccomponents.R
import com.example.developer.arccomponents.entities.Word



@Database(entities = [Word::class], version = 1)
abstract class WordRoomDatabase: RoomDatabase() {
    abstract fun wordDao(): WordDao
    companion object {
        @Volatile
        private var INSTANCE: WordRoomDatabase? = null
        fun getDatabase(context: Context): WordRoomDatabase {
            if (INSTANCE == null) {
                synchronized(WordRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,WordRoomDatabase::class.java,context.getString(R.string.dbName)).build()
                    }
                }
            }
            return INSTANCE!!
        }
    }
}