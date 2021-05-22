package com.example.vegetable_only

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Cart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}