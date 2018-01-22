package com.example.zhouzhihui.accessibilitydemo.access

import android.accessibilityservice.AccessibilityService

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