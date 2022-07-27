package com.e1ko0o.android.simplewordlearner.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.e1ko0o.android.simplewordlearner.R
import com.e1ko0o.android.simplewordlearner.databinding.FragmentLearnWordsBinding
import com.e1ko0o.android.simplewordlearner.viewmodels.LearnViewModel


class LearnFragment : Fragment(R.layout.fragment_learn_words) {
    private val viewBinding: FragmentLearnWordsBinding by viewBinding()
    private val viewModel: LearnViewModel by lazy { ViewModelProvider(this)[LearnViewModel::class.java] }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewBinding) {
            viewModel.ldWord.observe(viewLifecycleOwner) {
                tvWord.text = it
            }
            val pron = "'ɔtəm"
            tvPronunciation.text = "[${pron}]"

            btnShowTranslate.setOnClickListener {
                if (btnShowTranslate.text == resources.getText(R.string.show_translate)) {
                    tvTranslatedWord.text = "Ворчливый"

                    tvTranslatedWord.visibility = View.VISIBLE
                    btnShowTranslate.text = resources.getText(R.string.hide_translate)
                } else {
                    tvTranslatedWord.visibility = View.GONE
                    btnShowTranslate.text = resources.getText(R.string.show_translate)
                }
            }
            btnShowImage.setOnClickListener {
                if (btnShowImage.text == resources.getText(R.string.show_image)) {
                    viewModel.getImage().into(ivImage)
                    ivImage.visibility = View.VISIBLE
                    btnShowImage.text = resources.getText(R.string.hide_image)
                } else {
                    ivImage.visibility = View.GONE
                    btnShowImage.text = resources.getText(R.string.show_image)
                }
            }
            btnLearnWord.setOnClickListener { }
            btnWordLearned.setOnClickListener { }
            btnCopyWord.setOnClickListener {
                if (btnCopyWord.text == resources.getText(R.string.copy))
                    if (viewModel.copyText(tvWord.text.toString())) {
                        btnCopyWord.text = resources.getText(R.string.done)
                        btnCopyWord.isEnabled = false
                    } else
                        btnCopyWord.text = resources.getText(R.string.error)
            }
        }
    }

    companion object {
        private var instance: LearnFragment? = null

        fun getInstance(): LearnFragment {
            instance?.let {
                return it
            }
            return LearnFragment()
        }
    }
}