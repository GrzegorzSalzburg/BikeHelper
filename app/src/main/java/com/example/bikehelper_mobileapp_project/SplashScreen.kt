package com.example.bikehelper_mobileapp_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.content.ContextCompat

class SplashScreen : AppCompatActivity() {

    private lateinit var ivnote: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)

        ivnote = findViewById(R.id.iv_note)
        ivnote.alpha=0f
        ivnote.animate().setDuration(1500).alpha(1f).withEndAction {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }
    }
}