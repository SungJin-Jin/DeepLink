package io.datalive.deeplink.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import io.datalive.deeplink.activity.AfterInstallActivity
import io.datalive.deeplink.extensions.queryToMap

class ReferrerReceiver : BroadcastReceiver() {

    companion object {
        private const val ACTION_INSTALL_REFERRER = "com.android.vending.INSTALL_REFERRER"

        private const val KEY_REFERRER = "referrer"
    }

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == ACTION_INSTALL_REFERRER) {
            context.startActivity(createDestination(context, getExtras(intent)))
        }
    }

    private fun getExtras(intent: Intent) = intent.extras.getString(KEY_REFERRER).queryToMap()

    private fun createDestination(context: Context, params: Map<String, String>): Intent {
        return Intent(context, AfterInstallActivity::class.java).apply {
            params.forEach { putExtra(it.key, it.value) }
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
    }
}

