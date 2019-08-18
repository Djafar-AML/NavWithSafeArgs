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
import com.example.navwithsafeargs.databinding.FragmentFriendBinding


/**
 * A simple [Fragment] subclass.
 *
 */
class FriendFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding =
            DataBindingUtil.inflate<FragmentFriendBinding>(inflater, R.layout.fragment_friend, container, false)

        val args: FriendFragmentArgs by navArgs()

        Toast.makeText(context, args.FragmentName, Toast.LENGTH_SHORT).show()

        binding.friendButton.setOnClickListener {

            val action = FriendFragmentDirections.actionFriendFragmentToHomeFragment("This msg passed from FriendFragment")

            it.findNavController().navigate(action)
        }

        return binding.root
    }


}
