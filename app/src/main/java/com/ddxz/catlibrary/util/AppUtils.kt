package com.ddxz.catlibrary.util

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