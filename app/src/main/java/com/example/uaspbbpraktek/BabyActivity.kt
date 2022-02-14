package com.example.uaspbbpraktek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class BabyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_baby)

        val actionbar= supportActionBar
        actionbar!!.title = "Baby Activity"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}