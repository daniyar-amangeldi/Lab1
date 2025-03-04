package com.example.lab

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts

class ShareStoryManager(private val activity: ComponentActivity) {

    fun start() {
        pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }

    private val pickMedia = activity.registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        if (uri != null) {
            Log.d("PhotoPicker", "Selected URI: $uri")
            shareToInstagram(uri)
        } else {
            Log.d("PhotoPicker", "No media selected")
        }
    }

    private fun shareToInstagram(uri: Uri) {
        val sourceApplication = "9387438648001015"
        val intent = Intent("com.instagram.share.ADD_TO_STORY")

        intent.putExtra("source_application", sourceApplication);
        intent.setDataAndType(uri, "image/jpeg")
        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)

        activity.startActivityForResult(intent, 0)
    }
}