@file:Suppress("DEPRECATION")

package com.knittertest.utils

import android.content.Context
import android.net.ConnectivityManager

/**
 * Network Utility to detect availability or unavailability of Internet connection
 */
object NetworkUtils {

    fun isOnline(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting && cm.activeNetworkInfo.isAvailable && cm.activeNetworkInfo.isConnected
    }
}
