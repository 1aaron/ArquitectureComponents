package com.example.developer.arccomponents.ViewModels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.example.developer.arccomponents.data.WordRepository
import com.example.developer.arccomponents.entities.Word

/**
 * Never pass context into ViewModel instances. Do not store Activity, Fragment, or View instances or their Context in the ViewModel.
 */
class WordViewModel(application: Application): AndroidViewModel(application) {
    private var mRespository: WordRepository = WordRepository(application)
    var mAllWords: LiveData<List<Word>> = mRespository.getAllWords()

    fun insert(word: Word){
        mRespository.insert(word)
    }
}