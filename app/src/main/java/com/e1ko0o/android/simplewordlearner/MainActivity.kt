package com.e1ko0o.android.simplewordlearner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isEmpty
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.e1ko0o.android.simplewordlearner.databinding.ActivityMainBinding
import com.e1ko0o.android.simplewordlearner.fragments.LearnFragment
import com.e1ko0o.android.simplewordlearner.fragments.LearnedFragment
import com.e1ko0o.android.simplewordlearner.fragments.LearningFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val viewBinding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding.bottomNavMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menuLearnWords -> changeFragment(LearnFragment.getInstance())
                R.id.menuLearnedWords -> changeFragment(LearnedFragment.getInstance())
                R.id.menuLearningWords -> changeFragment(LearningFragment.getInstance())
            }
            true
        }
    }

    override fun onPostResume() {
        super.onPostResume()
        if(viewBinding.container.isEmpty())
            changeFragment(LearnFragment.getInstance())
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            addToBackStack("$fragment")
            commit()
        }
    }
}