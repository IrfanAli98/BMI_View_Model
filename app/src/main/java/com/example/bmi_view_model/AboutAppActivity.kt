package com.example.bmi_view_model

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.bmi_view_model.databinding.ActivityAboutAppBinding

class AboutAppActivity : AppCompatActivity() {
    private lateinit var dataBinding:ActivityAboutAppBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_about_app)
        dataBinding.wvAbout.loadUrl("https://www.stylecraze.com/tools/bmi-calculator/")
    }
}