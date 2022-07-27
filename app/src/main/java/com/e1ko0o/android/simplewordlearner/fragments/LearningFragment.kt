package com.e1ko0o.android.simplewordlearner.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.e1ko0o.android.simplewordlearner.R
import com.e1ko0o.android.simplewordlearner.databinding.FragmentLearningWordsBinding

class LearningFragment: Fragment(R.layout.fragment_learning_words) {
    private val viewBinding: FragmentLearningWordsBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with (viewBinding) {
            tv.text = "Still learning words"
        }
    }

    companion object {
        private var instance: LearningFragment? = null

        fun getInstance(): LearningFragment {
            instance?.let {
                return it
            }
            return LearningFragment()
        }
    }
}