package io.datalive.deeplink.log

import android.content.Context
import android.net.Uri
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

object Logger {

    fun logEvent(context: Context, data: Uri, action: String) = FirebaseAnalytics.getInstance(context).logEvent(action, createBundle(data))

    private fun createBundle(data: Uri): Bundle {
        return Bundle().apply {
            data.queryParameterNames.forEach {
                putString(it, data.getQueryParameter(it))
            }
        }
    }
}