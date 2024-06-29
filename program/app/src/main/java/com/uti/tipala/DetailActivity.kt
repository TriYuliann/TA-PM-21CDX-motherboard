package com.uti.tipala

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_detail_activity)

        val title = findViewById<TextView>(R.id.detailTitle)
        val image = findViewById<ImageView>(R.id.detailImage)
        val desc = findViewById<TextView>(R.id.detailDesc)
        val mapsButton = findViewById<Button>(R.id.button4)

        // Mendapatkan data dari intent
        val data = intent.getParcelableExtra<DataClass>("android")

        if (data != null) {
            title.text = data.dataTitle
            image.setImageResource(data.dataDetailImage)
            desc.text = data.dataDesc

            // Debugging: Cek Latitude dan Longitude
            Log.d("DetailActivity", "Latitude: ${data.latitude}, Longitude: ${data.longitude}")

            // Menambahkan logika untuk tombol Maps
            mapsButton.setOnClickListener {
                val uri = "geo:${data.latitude},${data.longitude}?q=${data.latitude},${data.longitude}(${data.dataTitle})"
                Log.d("MapsIntent", "Launching maps with URI: $uri")
                val intent = Intent(Intent.ACTION_VIEW, android.net.Uri.parse(uri))
                intent.setPackage("com.google.android.apps.maps")  // Memastikan menggunakan Google Maps
                startActivity(intent)
            }
        }
    }
}