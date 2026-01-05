package com.ncorti.kotlin.template.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ncorti.kotlin.template.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // default fragment
        openFragment(ModsFragment())

        binding.btnMods.setOnClickListener { openFragment(ModsFragment()) }
        binding.btnMyMods.setOnClickListener { openFragment(MyModsFragment()) }
        binding.btnSettings.setOnClickListener { openFragment(SettingsFragment()) }
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
