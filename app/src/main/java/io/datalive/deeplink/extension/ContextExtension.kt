package io.datalive.deeplink.extension

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics


fun Context.logging(key: String, bundle: Bundle) = FirebaseAnalytics.getInstance(this).logEvent(key, bundle)

fun Intent.loggingQueryParams(context: Context, key: String) = {
    val bundle = Bundle()

    data.queryParameterNames.forEach { bundle.putString(it, data.getQueryParameter(it)) }

    context.logging(key, bundle)
}