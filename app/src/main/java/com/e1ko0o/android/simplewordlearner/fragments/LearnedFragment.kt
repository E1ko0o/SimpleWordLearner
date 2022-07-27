package com.e1ko0o.android.simplewordlearner.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.e1ko0o.android.simplewordlearner.R
import by.kirich1409.viewbindingdelegate.viewBinding
import com.e1ko0o.android.simplewordlearner.databinding.FragmentLearnedWordsBinding

class LearnedFragment: Fragment(R.layout.fragment_learned_words) {

    private val viewBinding: FragmentLearnedWordsBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewBinding) {
            tv.text = "Already learned words"
        }
    }

    companion object {
        private var instance: LearnedFragment? = null

        fun getInstance(): LearnedFragment {
            instance?.let {
                return it
            }
            return LearnedFragment()
        }
    }
}