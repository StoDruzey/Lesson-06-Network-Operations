package com.example.lesson06networkoperations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, ListFragment())
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

fun Fragment.pushSecondFragment(){
    (requireActivity() as MainActivity)
        .supportFragmentManager
        .beginTransaction()
        .replace(R.id.container, CounterFragment.getInstance(counter))
        .addToBackStack(null)
        .commit()
}