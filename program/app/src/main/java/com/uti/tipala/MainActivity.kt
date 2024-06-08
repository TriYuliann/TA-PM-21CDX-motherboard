package com.uti.tipala

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import com.uti.tipala.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // deklarasi variabel "binding"
        val binding = ActivityMainBinding.inflate(layoutInflater)
        // buat variabel "menu"
        var menu = 1
        setContentView(binding.root)

        // buka "fragment1"
        supportFragmentManager.beginTransaction().replace(R.id.frm_content, Menu1Fragment())
            .commit()


    }


}