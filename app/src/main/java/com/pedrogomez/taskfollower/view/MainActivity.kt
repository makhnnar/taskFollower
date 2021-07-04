package com.pedrogomez.taskfollower.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pedrogomez.taskfollower.databinding.ActivityMainBinding
import com.pedrogomez.taskfollower.presentation.CarsViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val carsViewModel : CarsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}