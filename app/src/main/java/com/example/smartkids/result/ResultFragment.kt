package com.example.smartkids.result

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

import com.example.smartkids.R
import com.example.smartkids.TYPES
import com.example.smartkids.databinding.ResultFragmentBinding

class ResultFragment : Fragment(),View.OnClickListener {


    private lateinit var  binding: ResultFragmentBinding
    private val args: ResultFragmentArgs by navArgs()
    private  var highScoreKey =""
    private lateinit var sharedPref:SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.result_fragment, container, false)

        binding.lifecycleOwner = this

        return  binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        sharedPref= context?.getSharedPreferences(getString(R.string.preference_file_key),Context.MODE_PRIVATE)!!

         highScoreKey = if(args.type == TYPES.SHAPE){
            getString(R.string.saved_high_score_shape_key)
        }else{
            getString(R.string.saved_high_score_color_key)
        }
        //read from shared preference
         //sharedPref?: return
        val  highScoreSaved =  sharedPref.getString(highScoreKey,"0")
        val highScore:String

        if(highScoreSaved?.toInt()!! < args.score.toInt()) {
           highScore = args.score

           //write to shared preference
           with(sharedPref.edit()) {
               putString(highScoreKey, args.score)
               commit()
           }
       }else{
           highScore = highScoreSaved
       }


        binding.highScore.text = highScore

        binding.currentScore.text = args.score
        binding.btnHome.setOnClickListener(this)
        binding.btnRetry.setOnClickListener(this)
        binding.btnReset.setOnClickListener(this)

}
    override fun onClick(v: View?) {
        when (v) {
            binding.btnHome -> {
                findNavController().navigate(R.id.action_resultFragment_to_mainFragment)

            }
            binding.btnRetry -> {
                if (args.type == TYPES.SHAPE) {
                    val action =
                        ResultFragmentDirections.actionResultFragmentToGameFragment(TYPES.SHAPE)
                    findNavController().navigate(action)
                } else {
                    val action =
                        ResultFragmentDirections.actionResultFragmentToGameFragment(TYPES.COlOR)
                    findNavController().navigate(action)
                }
            }
            binding.btnReset -> {

                    with(sharedPref.edit()) {
                        putString(highScoreKey, "0")
                        commit() }
                    binding.highScore.text = "0"
                    binding.currentScore.text = "0"
            }
        }

    }
}
