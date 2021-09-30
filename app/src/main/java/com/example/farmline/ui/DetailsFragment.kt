package com.example.farmline.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.farmline.R
import com.example.farmline.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private val args: DetailsFragmentArgs by navArgs()
    private val detailsVM: DetailsVM by viewModels()
    private lateinit var binding: FragmentDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val newsPassed = arguments?.let { DetailsFragmentArgs.fromBundle(it).newsDatas}


        binding = FragmentDetailsBinding.inflate(inflater,container,false)
        binding.model = args.newsDatas
       detailsVM.initiate(context,newsPassed)
       return binding.root
    }

}