package com.example.smartkids.main

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.smartkids.R
import com.example.smartkids.TYPES
import com.example.smartkids.databinding.MainFragmentBinding


class MainFragment : Fragment() {



    private lateinit var  binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = DataBindingUtil.inflate(
            inflater,
            R.layout.main_fragment, container, false)

        val spannable = SpannableString(getString(R.string.color_text))
        spannable.setSpan(
            ForegroundColorSpan(Color.RED),
            0, 1,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannable.setSpan(
            ForegroundColorSpan(Color.MAGENTA),
            1, 2,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannable.setSpan(
            ForegroundColorSpan(Color.YELLOW),
            2, 3,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannable.setSpan(
            ForegroundColorSpan(Color.GREEN),
            3, 4,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannable.setSpan(
            ForegroundColorSpan(Color.BLUE),
            4, 5,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannable.setSpan(
            ForegroundColorSpan(Color.MAGENTA),
            5, 6,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

          binding.txtColor.setText(spannable, TextView.BufferType.SPANNABLE)


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


           binding.shapeGroup.setOnClickListener{
              // findNavController().navigate(R.id.action_mainFragment_to_shapeFragment)
//               val score = viewModel.score.toString()
//               val action = ShapeFragmentDirections.actionShapeFragmentToResultFragment(score,"shape")
//               findNavController().navigate(action)
               val action = MainFragmentDirections.actionMainFragmentToGameFragment(TYPES.SHAPE)
               findNavController().navigate(action)

           }

           binding.colorGroup.setOnClickListener{
             //  findNavController().navigate(R.id.action_mainFragment_to_colorFragment)
               val action = MainFragmentDirections.actionMainFragmentToGameFragment(TYPES.COlOR)
               findNavController().navigate(action)
           }

    }

}
