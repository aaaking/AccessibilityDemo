package com.example.zhouzhihui.accessibilitydemo.access

import android.accessibilityservice.AccessibilityService
import android.content.Context
import android.provider.Settings
import android.text.TextUtils

/**
 * Created by 周智慧 on 22/01/2018.
 */
val TAG = AccessibilityService::class.java.simpleName

fun listToString(list : List<Any>?): String {
    var result = StringBuilder("")
    list?.forEach {
        result.append("${it.toString()}\t")
    }
    return result.toString()
}

fun isPrePagePacket(prePageName: String): Boolean {
    return prePageName == "com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyReceiveUI" || prePageName == "com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI"
}

fun Context.isAccessibilityServiceOn(): Boolean {
    var service = "${packageName}/${MyAccessibilityService::class.java.canonicalName}"
    var enabled = Settings.Secure.getInt(applicationContext.contentResolver, Settings.Secure.ACCESSIBILITY_ENABLED)
    var splitter = TextUtils.SimpleStringSplitter(':')
    if (enabled == 1) {
        var settingValue = Settings.Secure.getString(applicationContext.contentResolver, Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES)
        if (settingValue != null) {
            splitter.setString(settingValue)
            while (splitter.hasNext()) {
                var accessibilityService = splitter.next()
                if (accessibilityService.equals(service, ignoreCase = true)) {
                    return true
                }
            }
        }
    }
    return false
}