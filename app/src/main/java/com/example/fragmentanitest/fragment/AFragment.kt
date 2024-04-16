package com.example.fragmentanitest.fragment

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.translation.ViewTranslationCallback
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.fragment.findNavController
import com.example.fragmentanitest.R
import com.example.fragmentanitest.widget.CustomFrameLayout

class AFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
            return ComposeView(requireContext()).apply {
                setContent {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "AFragment", fontSize = 30.sp)

                        Button(
                            modifier = Modifier.align(Alignment.BottomCenter),
                            onClick = {
                                findNavController().navigate(
                                    resId = R.id.bFragment,
                                    args = null,
                                    navOptions = NavOptions.Builder().apply {
                                        setEnterAnim(R.anim.slide_in_right)
                                        setExitAnim(R.anim.slide_out_left)
                                        setPopExitAnim(R.anim.slide_out_right)
                                        setPopEnterAnim(R.anim.slide_in_left)
                                    }.build()
                                )
                            }
                        ) {
                            Text(text = "Gogo")
                        }
                    }
                }
            }
    }


    override fun onDestroyView() {
        super.onDestroyView()

        Log.d("bustle.jang", "AFragment - onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("bustle.jang", "AFragment - onDestroy")
    }
}