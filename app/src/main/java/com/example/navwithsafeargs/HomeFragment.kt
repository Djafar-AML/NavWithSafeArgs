package com.example.navwithsafeargs


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navwithsafeargs.databinding.FragmentHomeBinding


/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater, R.layout.fragment_home, container, false)

        val args : HomeFragmentArgs by navArgs()
//        if (args.CallerFragmentName != "Null"){
            Toast.makeText(context, args.CallerFragmentName, Toast.LENGTH_SHORT).show()
//        }

        binding.homeButton.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToFriendFragment("This msg passed from HomeFragment")

            it.findNavController().navigate(action)
        }

        return binding.root
    }


}
