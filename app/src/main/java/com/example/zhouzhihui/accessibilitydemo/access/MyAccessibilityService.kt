package com.example.zhouzhihui.accessibilitydemo.access

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent

/**
 * Created by 周智慧 on 22/01/2018.
 */

class MyAccessibilityService : AccessibilityService() {
    override fun onInterrupt() {
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
//        val serviceInfo = AccessibilityServiceInfo()
//        serviceInfo.eventTypes = AccessibilityEvent.TYPES_ALL_MASK//typeNotificationStateChanged|typeWindowStateChanged|typeWindowContentChanged
//        serviceInfo.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC//feedbackGeneric
//        serviceInfo.packageNames = arrayOf("com.tencent.mm")//com.tencent.mm
//        serviceInfo.notificationTimeout = 100
//        serviceInfo.flags = AccessibilityServiceInfo.DEFAULT
////        //android:canRetrieveWindowContent="true"
////        serviceInfo.canRetrieveWindowContent = true
//        setServiceInfo(serviceInfo)
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        dispatchEvent(event, rootInActiveWindow)
    }
}