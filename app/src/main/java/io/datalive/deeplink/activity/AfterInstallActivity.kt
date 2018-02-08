package io.datalive.deeplink.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.datalive.deeplink.R
import io.datalive.deeplink.extension.loggingQueryParams
import kotlinx.android.synthetic.main.activity_install.*

class AfterInstallActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_install)

        txtContent.text = intent.data.query

        loggingQueryParams(intent, "after_install")

    }
}
