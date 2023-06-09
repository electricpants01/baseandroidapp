package com.locotodevteam.androidbaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.locotodevteam.androidbaseapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
    }
}