package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.Fragment1Binding
import com.example.myapplication.databinding.Fragment2Binding

class Fragment2 : Fragment(R.layout.fragment_2) {

    private lateinit var binding: Fragment2Binding
    private val args: Fragment2Args by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment2Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txt.setOnClickListener {
            findNavController().navigate(R.id.action_fragment2_to_fragment1)
        }
        binding.txt.text = "${binding.txt.text.toString()} ${args.name}"
    }
}