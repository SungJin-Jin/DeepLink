package io.datalive.deeplink.activity


import android.os.Bundle
import io.datalive.deeplink.R
import io.datalive.deeplink.common.BaseActivity
import io.datalive.deeplink.common.Constants.ACTION_DEEP_LINK
import kotlinx.android.synthetic.main.activity_deep_link.*

class DeepLinkActivity : BaseActivity() {

    override fun getAction() = ACTION_DEEP_LINK

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deep_link)

        txtContent.text = intent.data.query
    }
}
