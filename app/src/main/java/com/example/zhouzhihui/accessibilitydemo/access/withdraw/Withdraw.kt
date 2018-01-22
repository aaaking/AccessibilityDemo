package com.example.zhouzhihui.accessibilitydemo.access.withdraw

import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import com.example.zhouzhihui.accessibilitydemo.access.TAG
import java.util.*

/**
 * Created by 周智慧 on 22/01/2018.
 */
class Withdraw {
    fun withDraw(event: AccessibilityEvent?, root: AccessibilityNodeInfo?) {
        var cs = event?.source?.text
        Log.i(TAG, "event: ${event}:   root: ${root}")
        val in1 = Date()
    }
}
