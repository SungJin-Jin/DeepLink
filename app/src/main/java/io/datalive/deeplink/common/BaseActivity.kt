package io.datalive.deeplink.common

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.datalive.deeplink.log.Logger

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Logger.logEvent(this, intent.data, getAction())
    }

    abstract fun getAction(): String
}