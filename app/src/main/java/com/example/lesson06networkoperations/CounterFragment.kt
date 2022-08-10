package com.example.lesson06networkoperations


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.lesson06networkoperations.databinding.FragmentCounterBinding

class CounterFragment private constructor(): Fragment() {

    private var _binding: FragmentCounterBinding? = null
    private val binding get() = requireNotNull(_binding) { "view was destroyed" }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentCounterBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            var counter = requireArguments().getInt(KEY_COUNTER)
            textCounter.text = counter.toString()

            textCounter.setOnClickListener {
                Toast.makeText(root.context, "some text", Toast.LENGTH_LONG).show()
            }

            buttonPlus.setOnClickListener {
                textCounter.text = (++counter).toString()
            }
            buttonMinus.setOnClickListener {
                textCounter.text = (--counter).toString()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val KEY_COUNTER = "key_counter"
        fun getInstance(counter: Int) : CounterFragment {
            return CounterFragment().apply {
                arguments = bundleOf(
                    KEY_COUNTER to counter
                )
            }
        }
    }
}