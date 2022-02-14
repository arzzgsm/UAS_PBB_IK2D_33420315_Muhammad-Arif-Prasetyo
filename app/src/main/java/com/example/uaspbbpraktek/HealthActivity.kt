package com.example.uaspbbpraktek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class HealthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_health)

        val actionbar= supportActionBar
        actionbar!!.title = "Health Activity"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}