package com.example.android.playquiz

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel:ViewModel() {
    val score = MutableLiveData<Int>()

    init {
        score.value = 0
    }
}