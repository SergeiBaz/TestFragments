package com.example.testfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.testfragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        openFragment(BlankFragment.newInstance(), R.id.place_holder)
        openFragment(BlankFragment2.newInstance(), R.id.place_holder2)
        dataModel.messageForActivity.observe(this) {
            binding.textView.text = it
        }
    }

    private fun openFragment(fragment: Fragment, idHolder: Int){
        supportFragmentManager.beginTransaction().replace(idHolder, fragment).commit()
    }
}