package com.example.developer.arccomponents.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.developer.arccomponents.R
import com.example.developer.arccomponents.entities.Word

class WordListAdapter(context: Context): RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {
    private var mInflater: LayoutInflater = LayoutInflater.from(context)
    private var mWords: List<Word>? = null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): WordListAdapter.WordViewHolder {
        val itemview = mInflater.inflate(R.layout.recyclerview_item,p0,false)
        return WordViewHolder(itemview)
    }

    override fun getItemCount(): Int {
        return if (mWords!=null) {
            mWords!!.size
        } else {
            0
        }
    }

    fun setWords(words: List<Word>) {
        mWords = words
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(p0: WordListAdapter.WordViewHolder, p1: Int) {
        mWords?.let {
            val current = it[p1]
            p0.wordItemView.text = current.getWord()
            return
        }
        p0.wordItemView.text = "No Word"
    }

    inner class WordViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var wordItemView: TextView = itemView.findViewById(R.id.textView)
    }
}