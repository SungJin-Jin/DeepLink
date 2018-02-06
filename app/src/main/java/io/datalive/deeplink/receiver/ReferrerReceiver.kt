package io.datalive.deeplink.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import io.datalive.deeplink.activity.InstallActivity
import io.datalive.deeplink.extension.getString
import io.datalive.deeplink.singletons.Configs.KEY_REFERRER

class ReferrerReceiver : BroadcastReceiver() {

    companion object {
        private val ACTION_INSTALL_REFERRER = "com.android.vending.INSTALL_REFERRER"
    }

    override fun onReceive(context: Context, intent: Intent) {
        intent.let {
            when (intent.action) {
                ACTION_INSTALL_REFERRER -> {
                    val install = Intent(context, InstallActivity::class.java)
                    context.startActivity(
                            install.putExtra(KEY_REFERRER, intent.getString(KEY_REFERRER))
                                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    )
                }
            }
        }
    }
}
