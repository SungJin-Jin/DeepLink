package io.datalive.deeplink.activity

import android.os.Bundle
import io.datalive.deeplink.R
import io.datalive.deeplink.common.BaseActivity
import io.datalive.deeplink.common.Constants.ACTION_DYNAMIC_LINK
import kotlinx.android.synthetic.main.activity_dynamic_link.*

class DynamicLinkActivity : BaseActivity() {

    override fun getAction() = ACTION_DYNAMIC_LINK

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic_link)

        txtContent.text = intent.data.query
    }
}
