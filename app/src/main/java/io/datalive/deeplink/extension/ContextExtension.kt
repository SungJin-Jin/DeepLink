package io.datalive.deeplink.extension

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.analytics.FirebaseAnalytics


fun Context.logging(key: String, bundle: Bundle) = FirebaseAnalytics.getInstance(this).logEvent(key, bundle)

fun Context.loggingQueryParams(intent: Intent, key: String) = {
    var bundle = Bundle()

    intent.data.queryParameterNames.forEach {
        bundle.putString(it, intent.data.getQueryParameter(it))
    }

    logging(key, bundle)
}

fun Context.toast(message:String) = Toast.makeText(this, message, Toast.LENGTH_LONG).show()