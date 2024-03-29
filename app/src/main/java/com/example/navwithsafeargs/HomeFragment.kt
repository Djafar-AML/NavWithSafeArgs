package com.example.navwithsafeargs


import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.navwithsafeargs.databinding.FragmentHomeBinding


/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )

        // safe args
        val args: HomeFragmentArgs by navArgs()

        if (args.CallerFragmentName != "Null") {
            Toast.makeText(context, args.CallerFragmentName, Toast.LENGTH_SHORT).show()
        }

//        // update UI component with navigation UI
//        val navController = findNavController()
//        appBarConfiguration = AppBarConfiguration(navGraph = navController.graph)
//        NavigationUI.setupActionBarWithNavController(activity , navController)


        binding.homeButton.setOnClickListener {
            val action =
                HomeFragmentDirections.actionHomeFragmentToFriendFragment("This msg passed from HomeFragment")

            it.findNavController().navigate(action)
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            view!!.findNavController()
        ) || super.onOptionsItemSelected(item)
    }


}
