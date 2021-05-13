package com.example.smartkids.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

import com.example.smartkids.R
import com.example.smartkids.databinding.GameFragmentBinding

class GameFragment : Fragment(),View.OnClickListener {


    private lateinit var viewModel: GameViewModel
    private lateinit var  binding: GameFragmentBinding
    private lateinit var viewModelFactory: GameViewModelFactory
    //arguments
    private val args: GameFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.game_fragment, container, false)
        binding.lifecycleOwner = this



        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
         //pass data to ViewModel by ViewModelFactory
         viewModelFactory = GameViewModelFactory(args.type)
         viewModel= ViewModelProvider(this,viewModelFactory).get<GameViewModel>(
            GameViewModel::class.java)
          binding.viewModel = viewModel

        binding.object1.setOnClickListener(this)
        binding.object2.setOnClickListener(this)
        binding.object3.setOnClickListener(this)


        viewModel.correctAnswer.observe(viewLifecycleOwner, Observer {
            if (!it) {
                binding.imgError.visibility = View.VISIBLE
                binding.imgShape.alpha = 0.3f

            }else{
                binding.imgShape.alpha = 1.0f
                binding.imgError.visibility = View.GONE
            }

        })
        viewModel.navigateToResult.observe(viewLifecycleOwner, Observer {
            if(it){
                //navigate to Result Fragment with passing "score" and "type"(GAME TYPE) data
                val score = viewModel.score.toString()
                val action = GameFragmentDirections.actionGameFragmentToResultFragment(score,args.type)
                findNavController().navigate(action)
            }
            viewModel.onNavigationCompleted()
        })
    }

    override fun onClick(v: View?) {

        when(v){
            binding.object1 -> viewModel.onClickEvent(0)
            binding.object2 -> viewModel.onClickEvent(1)
            binding.object3 -> viewModel.onClickEvent(2)

        }
    }

}

