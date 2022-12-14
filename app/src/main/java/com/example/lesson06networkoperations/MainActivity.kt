package com.example.lesson06networkoperations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, FirstFragment())
                .commit()
        }
    }
}

fun Fragment.pushFragment(counter: Int) {
    (requireActivity() as MainActivity)
        .supportFragmentManager
        .beginTransaction()
        .replace(R.id.container, CounterFragment.getInstance(counter))
        .addToBackStack(null)
        .commit()
}

fun Fragment.pushSecondFragment(isCheked: Boolean){
    (requireActivity() as MainActivity)
        .supportFragmentManager
        .beginTransaction()
        .replace(R.id.container, FragmentSecond()).apply {
            arguments = bundleOf("second" to isCheked)
        }
        .addToBackStack(null)
        .commit()
}