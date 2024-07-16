package com.example.wasteapps.home.ui.profile.ubah_profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wasteapps.R
import com.example.wasteapps.home.ui.profile.ubah_profile.ui.main.UbahProfileFragment

class UbahProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ubah_profile)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, UbahProfileFragment.newInstance())
                .commitNow()
        }
    }
}