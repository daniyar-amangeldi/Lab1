package com.example.lab

import android.content.Intent
import android.content.IntentFilter
import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat

class AirplaneModeListenerManager(private val activity: ComponentActivity) {

    fun start() {
        val intentFilter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        val flag = ContextCompat.RECEIVER_EXPORTED

        ContextCompat.registerReceiver(activity, NetworkConnectivityReceiver(), intentFilter, flag)
    }
}