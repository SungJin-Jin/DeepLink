package io.datalive.deeplink.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import io.datalive.deeplink.activity.AfterInstallActivity
import io.datalive.deeplink.activity.DeepLinkActivity
import io.datalive.deeplink.activity.DynamicLinkActivity
import io.datalive.deeplink.extension.moveActivityWithExtraData

class ReferrerReceiver : BroadcastReceiver() {

    companion object {
        private const val ACTION_INSTALL_REFERRER = "com.android.vending.INSTALL_REFERRER"
    }

    override fun onReceive(context: Context, receiverIntent: Intent) {
        when (receiverIntent.action) {
            ACTION_INSTALL_REFERRER -> {
                with(receiverIntent.extras) {
                    val paramMap = toMap(getString("referrer"))

                    val destIntent = when (paramMap["where"]) {
                        "deepLink" -> Intent(context, DeepLinkActivity::class.java)
                        "dynamicLink" -> Intent(context, DynamicLinkActivity::class.java)
                        else -> Intent(context, AfterInstallActivity::class.java)
                    }

                    context.moveActivityWithExtraData(destIntent, receiverIntent)
                }
            }
        }
    }

    private fun toMap(queryString: String) =
            queryString.split("&").map {
                it.split("=")
            }.map { it[0] to it[1] }.toMap()

}

