package io.datalive.myreferrer

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class ReferrerReceiver : BroadcastReceiver() {

    companion object {
        private val ACTION_INSTALL_REFERRER = "com.android.vending.INSTALL_REFERRER"
    }

    override fun onReceive(context: Context, intent: Intent?) {
        intent?.let {
            when (intent.action) {
                ACTION_INSTALL_REFERRER -> {
                    intent.extras?.getString("referrer").let {
                        val intent = Intent(context, FirstInstallActivity::class.java)
                                .putExtra("referrer", it)
                                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

                        context.startActivity(intent)
                    }
                }
            }
        }
    }
}
