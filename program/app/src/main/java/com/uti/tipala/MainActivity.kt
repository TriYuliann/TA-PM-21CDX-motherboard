package com.uti.tipala

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import com.uti.tipala.databinding.ActivityMainBinding
import android.view.MenuItem
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

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

        // buat event untuk "menu1"
        binding.btnMenu1.setOnClickListener {
            menu = 1

            // Tampilkan fram "lay_button
            binding.layButton.visibility = View.VISIBLE

            supportFragmentManager.beginTransaction().replace(R.id.frm_content, Menu1Fragment())
                .commit()
        }
        // buat event untuk "menu2"
        binding.btnMenu2.setOnClickListener {
            menu = 2

            // Tampilkan fram "lay_button
            binding.layButton.visibility = View.VISIBLE

            supportFragmentManager.beginTransaction().replace(R.id.frm_content, Menu2Fragment())
                .commit()
        }
        // buat event untuk "menu3"
        binding.btnMenu3.setOnClickListener {
            menu = 3

            // Tampilkan fram "lay_button
            binding.layButton.visibility = View.VISIBLE

            supportFragmentManager.beginTransaction().replace(R.id.frm_content, Menu3Fragment())
                .commit()
        }

        // buat event "backpressed"
        onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // jika menu = 2 atau menu = 3
                // if (menu != 1) { // PENJELASAN MENU 1-100 AKAN KEMBALI KE MENU 1
                if (menu == 2 || menu == 3) {
                    // panggil event "btnMenu1"
                    binding.btnMenu1.performClick()
                }
            }

        })


    }


}