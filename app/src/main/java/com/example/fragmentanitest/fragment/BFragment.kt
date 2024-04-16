package com.example.fragmentanitest.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment

class BFragment : Fragment() {
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
                    Text(text = "BFragment", fontSize = 30.sp)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        Log.d("bustle.jang", "BFragment - onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("bustle.jang", "BFragment - onDestroy")
    }
}