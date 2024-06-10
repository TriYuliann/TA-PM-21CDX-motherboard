package com.uti.tipala

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.OnBackPressedCallback
import com.uti.tipala.databinding.ActivityMainBinding

class menu_login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_login)

        // deklarasi variabel komponen
        val btnLogin: ImageView = findViewById(R.id.btnLogin)

        // 2. event untuk "btnlogin"
        btnLogin.setOnClickListener {
            // buka "main_activity/menu utama apk"
            //Intent(Sumber, Tujuan)
            val intent = Intent(this,
                menu_login::class.java)
            startActivity(intent)
        }
    }
}