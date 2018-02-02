package io.datalive.myreferrer.extension

import android.app.Activity
import android.content.Intent


fun Activity.inflowValue(key: String) = intent.data.getQueryParameter(key)

fun Intent.getString(key: String) = extras.getString(key)