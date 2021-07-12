package com.example.android.playquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs


/**
 * A simple [Fragment] subclass.
 * Use the [ScorePage.newInstance] factory method to
 * create an instance of this fragment.
 */
class ScorePage : Fragment() {
    // TODO: Rename and change types of parameters

    val viewModel:ScoreViewModel by activityViewModels()
    val args:ScorePageArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_score_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val score_text = view.findViewById<TextView>(R.id.tv_score)
        score_text.setText(viewModel.score.value.toString())
        val corrects_text = view.findViewById<TextView>(R.id.tv_corrects)
        corrects_text.setText(args.corrects.toString())
        val finishButton = view.findViewById<Button>(R.id.btn_finish)
        finishButton.setOnClickListener {
            it.findNavController().navigate(ScorePageDirections.actionScorePageToHomePage())
        }

    }
}