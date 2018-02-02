package io.datalive.myreferrer.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import io.datalive.myreferrer.activity.InstallActivity
import io.datalive.myreferrer.extension.getString
import io.datalive.myreferrer.singletons.Configs.KEY_REFERRER

class ReferrerReceiver : BroadcastReceiver() {

    companion object {
        private val ACTION_INSTALL_REFERRER = "com.android.vending.INSTALL_REFERRER"
    }

    override fun onReceive(context: Context, intent: Intent) {
        intent.let {
            when (intent.action) {
                ACTION_INSTALL_REFERRER -> {
                    it.getString(KEY_REFERRER).let {
                        context.startActivity(
                                Intent(context, InstallActivity::class.java)
                                        .putExtra(KEY_REFERRER, it)
                                        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        )
                    }
                }
            }
        }
    }
}
