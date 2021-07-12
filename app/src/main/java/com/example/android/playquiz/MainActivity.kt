package com.example.android.playquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {
    private val viewModel:ScoreViewModel by viewModels()
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


}