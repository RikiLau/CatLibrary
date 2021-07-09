package com.ddxz.catlibrary.util

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.Log

private const val TAG = "SystemFun"

/**
 * 获取捕捉到的Exception信息，并转化为字符串
 */
fun printExceptionInfo(pEx: Exception) {
    var exStr = """
         $pEx
         
         """.trimIndent()
    val stackTraceElements = pEx.stackTrace
    for (se in stackTraceElements) {
        exStr += """
            at ${se.className}.${se.methodName}(${se.fileName}:${se.lineNumber})
            
            """.trimIndent()
    }
    Log.w(TAG, exStr)
}

fun getDisplayWidth (context: Context): Int {
    val resources: Resources = context.resources
    val dm: DisplayMetrics = resources.displayMetrics
    return dm.widthPixels
}