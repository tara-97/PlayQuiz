package com.example.android.playquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.findFragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QuizPage2.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuizPage2 : Fragment() {

    val viewModel:ScoreViewModel by activityViewModels()
    var scores = 0
    val args:QuizPage2Args by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz_page2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val next = view.findViewById<Button>(R.id.btn_next1)
        next.setOnClickListener {
            val radioGroup = view.findViewById<RadioGroup>(R.id.rg1)
            val checkedId = radioGroup.checkedRadioButtonId
            if(checkedId == R.id.rd3){
                scores= args.corrects+1
                viewModel.score.value = viewModel.score.value?.plus(1)
            }else{
                scores = args.corrects
            }
            it.findNavController().navigate(QuizPage2Directions.actionQuizPage2ToScorePage(scores))

        }
    }


}