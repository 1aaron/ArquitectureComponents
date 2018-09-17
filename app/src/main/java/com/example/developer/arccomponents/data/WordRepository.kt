package com.example.developer.arccomponents.data

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import com.example.developer.arccomponents.Daos.WordDao
import com.example.developer.arccomponents.entities.Word

class WordRepository(application: Application) {
    private var wordDao : WordDao? = null
    private var mAllWords: LiveData<List<Word>>? = null

    init {
        val db = WordRoomDatabase.getDatabase(application)
        wordDao = db.wordDao()
        mAllWords = wordDao?.getAllWords()
    }
    fun getAllWords(): LiveData<List<Word>>? {
        return mAllWords
    }

    fun insert(word:  Word) {
        wordDao?.let {
            insertAsynctask(it).execute(word)
        }
    }

    inner class insertAsynctask(val dao: WordDao) : AsyncTask<Word, Void, Void>() {
        override fun doInBackground(vararg params: Word?): Void? {
            dao.insert(params[0]!!)
            return null
        }
    }
}