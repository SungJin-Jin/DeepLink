package io.datalive.deeplink.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.Uri
import io.datalive.deeplink.activity.AfterInstallActivity
import io.datalive.deeplink.activity.DeepLinkActivity
import io.datalive.deeplink.activity.DynamicLinkActivity
import io.datalive.deeplink.extension.toast

class ReferrerReceiver : BroadcastReceiver() {

    companion object {
        private val ACTION_INSTALL_REFERRER = "com.android.vending.INSTALL_REFERRER"
    }

    override fun onReceive(context: Context, receiverIntent: Intent) {
        when (receiverIntent.action) {
            ACTION_INSTALL_REFERRER -> {
                with(receiverIntent.extras) {
                    context.toast(keySet().joinToString { key -> getString(key) })

                    var paramMap = toMap(getString("referrer"))

//                    context.toast(paramMap.toString())

                    val destIntent = when (paramMap["where"]) {
                        "deepLink" -> Intent(context, DeepLinkActivity::class.java)
                        "dynamicLink" -> Intent(context, DynamicLinkActivity::class.java)
                        else -> Intent(context, AfterInstallActivity::class.java)
                    }

                    moveActivity(destIntent, receiverIntent, context)
                }
            }
        }
    }

    private fun toMap(queryString: String): Map<String, String> {
        return queryString.split("&").map {
            it.split("=")
        }.map { it[0] to it[1] }.toMap()
    }

    private fun moveActivity(destIntent: Intent, receiverIntent: Intent, context: Context) {
        with(destIntent) {
            destIntent.data = Uri.parse("http://nethrureferrer-4b919.firebaseapp.com?" +
                    "${receiverIntent.extras.get("referrer")}"
            )

            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

            context.startActivity(this)
        }
    }
}

