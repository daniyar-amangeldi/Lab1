package com.example.lab

import android.content.Intent
import android.widget.Button
import androidx.activity.ComponentActivity

class MusicPlayerManager(private val activity: ComponentActivity) {

    fun start() {
        activity.findViewById<Button>(R.id.start).setOnClickListener {
            val serviceIntent = Intent(activity, MusicPlayerService::class.java).apply {
                action = MusicPlayerService.START_MUSIC
            }
            activity.startForegroundService(serviceIntent)
        }

        activity.findViewById<Button>(R.id.stop).setOnClickListener {
            val serviceIntent = Intent(activity, MusicPlayerService::class.java).apply {
                action = MusicPlayerService.STOP_MUSIC
            }
            activity.startForegroundService(serviceIntent)
        }
    }
}