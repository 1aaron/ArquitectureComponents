package com.example.developer.arccomponents.data

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import com.example.developer.arccomponents.Daos.WordDao
import com.example.developer.arccomponents.entities.Word

class WordRepository(application: Application) {
    val db = WordRoomDatabase.getDatabase(application)
    private var wordDao =  db.wordDao()
    private var mAllWords = wordDao.getAllWords()

    fun getAllWords(): LiveData<List<Word>> {
        return mAllWords
    }

    fun insert(word:  Word) {
        insertAsynctask(wordDao).execute(word)
    }

    inner class insertAsynctask(val dao: WordDao) : AsyncTask<Word, Void, Void>() {
        override fun doInBackground(vararg params: Word?): Void? {
            dao.insert(params[0]!!)
            return null
        }
    }
}