package io.datalive.deeplink.extension

import android.content.Context
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics


fun Context.logging(key: String, bundle: Bundle) = FirebaseAnalytics.getInstance(this).logEvent(key, bundle)

