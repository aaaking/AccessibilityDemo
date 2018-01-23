package com.example.zhouzhihui.accessibilitydemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import com.example.zhouzhihui.accessibilitydemo.access.isAccessibilityServiceOn
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hello.also {
            val isOn = isAccessibilityServiceOn()
            it.text = if (isOn) "服务已经开启" else "点击开启服务"
            it.isEnabled = !isOn
            it.setOnClickListener {
                startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
            }
        }
    }
}
