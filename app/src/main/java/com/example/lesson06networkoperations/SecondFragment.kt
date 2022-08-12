package com.example.lesson06networkoperations

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.lesson06networkoperations.databinding.FragmentSecondBinding

class FragmentSecond : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentSecondBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
//            var checkboxChecked = false
            var checkboxChecked = requireArguments().getBoolean("second")
            checkbox.isChecked = checkboxChecked
//            var textResult = ""

//            editText.addTextChangedListener {
//                textResult = it?.toString() ?: ""
//            }
            checkbox.setOnCheckedChangeListener { _, isChecked ->
                checkboxChecked = isChecked
            }
            button.setOnClickListener {
                parentFragmentManager.setFragmentResult(
                    "result",
                    bundleOf("key" to /*textResult*/checkboxChecked)
                )
                parentFragmentManager.popBackStack()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}