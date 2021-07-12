package com.example.android.playquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QuizPage1.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuizPage1 : Fragment() {
    val viewModel:ScoreViewModel by activityViewModels()
    var corrects = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz_page1, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val next = view.findViewById<Button>(R.id.btn_next)
        next.setOnClickListener {
            val radioGroup = view.findViewById<RadioGroup>(R.id.rg)
            val checkedId = radioGroup.checkedRadioButtonId
            if(checkedId == R.id.rd2){
                corrects+=1
                viewModel.score.value = viewModel.score.value?.plus(1)
            }
            it.findNavController().navigate(QuizPage1Directions.actionQuizPage1ToQuizPage2(corrects))

        }

    }
}