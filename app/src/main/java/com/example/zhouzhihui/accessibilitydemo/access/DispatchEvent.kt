package com.example.zhouzhihui.accessibilitydemo.access

import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import com.example.zhouzhihui.accessibilitydemo.access.withdraw.Withdraw

/**
 * Created by 周智慧 on 22/01/2018.
 */
fun dispatchEvent(event: AccessibilityEvent?, rootInActiveWindow: AccessibilityNodeInfo?) {
    val pkgName = event?.packageName.toString()
    val eventType = event?.getEventType()
    Log.i(TAG, "pkgName:${pkgName}     eventType:${eventType}      className:${event?.getClassName().toString()}      " +
            "event.text:${listToString(event?.text)} event?.getContentChangeTypes():${event?.getContentChangeTypes()}\n")
    when (eventType) {
        AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED -> com.example.zhouzhihui.accessibilitydemo.access.packet.handleNotification(event)//64     1-->click
        AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED, AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED -> {//32 2048
            val className = event.getClassName().toString()
            if (className == "com.tencent.mm.ui.LauncherUI" || className == "com.tencent.mm.ui.mogic.WxViewPager" || className == "android.widget.EditText"/* || className == "android.widget.ListView"*/) {
                com.example.zhouzhihui.accessibilitydemo.access.packet.searchPacket(rootInActiveWindow)
            } else if (className == "com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyReceiveUI") {//com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI
                com.example.zhouzhihui.accessibilitydemo.access.packet.openPacket(rootInActiveWindow)
            } else if (className == "com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI") {
                com.example.zhouzhihui.accessibilitydemo.access.packet.closePacket(rootInActiveWindow)
            }
        }
    }
    if (event?.getContentChangeTypes() == AccessibilityEvent.CONTENT_CHANGE_TYPE_TEXT) {
        Withdraw().withDraw(event, rootInActiveWindow)//防消息撤回
    }

    rootInActiveWindow?.recycle()//避免重复创建实例通过recycle方法回收掉nodeInfo（我们自己手动去回收）
}