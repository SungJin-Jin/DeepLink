package io.datalive.myreferrer.extension

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics


fun Context.logging(key: String, bundle: Bundle) = FirebaseAnalytics.getInstance(this).logEvent(key, bundle)

fun Intent.getString(key: String) = extras.getString(key)
