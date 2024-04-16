package com.example.fragmentanitest.fragment

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.translation.ViewTranslationCallback
import androidx.activity.OnBackPressedCallback
import androidx.annotation.RequiresApi
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.fragmentanitest.databinding.FragmentLayoutBinding

class ContainerFragment : Fragment() {

    private var binding: FragmentLayoutBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (binding?.fragmentContainer?.getFragment<NavHostFragment>()?.navController?.navigateUp() == false) {
                        requireActivity().finish()
                    }
                }
            }
        )
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AndroidViewBinding(FragmentLayoutBinding::inflate) {
                    Log.d("bustle.jang", "update")
                    binding = this
                }
            }
        }
    }
}