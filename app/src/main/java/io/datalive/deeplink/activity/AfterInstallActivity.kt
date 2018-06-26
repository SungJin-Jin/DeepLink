package io.datalive.deeplink.activity

import android.os.Bundle
import io.datalive.deeplink.R
import io.datalive.deeplink.R.id.txtContent
import io.datalive.deeplink.common.BaseActivity
import io.datalive.deeplink.common.Constants.ACTION_AFTER_INSTALL
import kotlinx.android.synthetic.main.activity_install.*

class AfterInstallActivity : BaseActivity() {

    override fun getAction() = ACTION_AFTER_INSTALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_install)

        txtContent.text = intent.data.query
    }
}
