package com.example.locoly.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.locoly.R

class WelcomeScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_screen)
    }

    fun gotoLogin(view: View) {
        startActivity(Intent(this,LoginActivity::class.java))
    }
}
