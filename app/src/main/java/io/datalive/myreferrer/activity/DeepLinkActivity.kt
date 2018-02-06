package io.datalive.myreferrer.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.datalive.myreferrer.R
import io.datalive.myreferrer.extension.logging
import kotlinx.android.synthetic.main.activity_deep_link.*

class DeepLinkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deep_link)

        with(intent.data) {
            txtContent.text = query

            if (query.isBlank()) return

            var bundle = Bundle()

            queryParameterNames.forEach { bundle.putString(it, getQueryParameter(it)) }

            logging("detail", bundle)
        }
    }
}
