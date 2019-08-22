package com.example.navwithsafeargs


import android.content.Intent
import android.os.Bundle
import android.view.*
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
            DataBindingUtil.inflate<FragmentFriendBinding>(
                inflater,
                R.layout.fragment_friend,
                container,
                false
            )

        val args: FriendFragmentArgs by navArgs()

        Toast.makeText(context, args.FragmentName, Toast.LENGTH_SHORT).show()



        binding.friendButton.setOnClickListener {

            val action =
                FriendFragmentDirections.actionFriendFragmentToHomeFragment("This msg passed from FriendFragment")

            it.findNavController().navigate(action)
        }

        //setup share button
        setHasOptionsMenu(true)

        return binding.root
    }

    // setup share button menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.share_menu, menu)

        // check if the activity resolves
        if (null == getShareIntent().resolveActivity(activity!!.packageManager)) {
            // hide the menu item if it doesn't resolve
            menu.findItem(R.id.share_menu).isVisible = false
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.title) {
            "Share" -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getShareIntent(): Intent {
        return Intent(Intent.ACTION_SEND).setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, "CefEr you made it!")
    }

    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

}
