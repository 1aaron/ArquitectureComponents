package com.example.developer.arccomponents.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

@Entity(tableName= "word_table")
class Word(word: String) {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name="word")
    private var mWord = word
    fun getWord(): String {
        return mWord
    }
}