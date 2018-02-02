package io.datalive.myreferrer.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.datalive.myreferrer.R
import io.datalive.myreferrer.singletons.Configs.KEY_REFERRER
import kotlinx.android.synthetic.main.activity_install.*

class InstallActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_install)

        intent.getStringExtra(KEY_REFERRER).let {
            txtReferrer.text = "Referrer : $it"
        }
    }
}
