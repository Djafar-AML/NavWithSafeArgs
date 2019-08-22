package com.example.navwithsafeargs


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.navwithsafeargs.databinding.FragmentHelpBinding


/**
 * A simple [Fragment] subclass.
 *
 */
class HelpFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentHelpBinding>(inflater, R.layout.fragment_help, container, false)
        return binding.root
    }


}
