package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.myapplication.core.BaseFragment
import com.example.myapplication.databinding.Fragment1Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment1 : BaseFragment<Fragment1Binding, MainViewModel>() {

    override val layoutId: Int = R.layout.fragment_1
    override val viewModel: MainViewModel by activityViewModels()

    override fun onReady(savedInstanceState: Bundle?) {

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnFragment2Nav.setOnClickListener {
            findNavController().navigate(R.id.action_fragment1_to_fragment2)
        }
    }

}