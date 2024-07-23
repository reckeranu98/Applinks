package com.lu.applinks

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val calAppBtn:Button = findViewById(R.id.calAppBtn)
        val statAppBtn: Button = findViewById(R.id.statAppBtn)

        calAppBtn.setOnClickListener{
            val launchIntent = packageManager.getLaunchIntentForPackage("com.lu.app2midterm")
            if (launchIntent != null) {
                startActivity(launchIntent) //null pointer check in case package name was not found
            }
        }

        statAppBtn.setOnClickListener{
            val launchIntent = packageManager.getLaunchIntentForPackage("com.lu.calculator")
            if (launchIntent != null) {
                startActivity(launchIntent) //null pointer check in case package name was not found
            }
        }
    }
}