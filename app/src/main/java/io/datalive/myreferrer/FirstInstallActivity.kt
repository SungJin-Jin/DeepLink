package io.datalive.myreferrer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_first_install.*

class FirstInstallActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_install)

        intent.getStringExtra("referrer").let {
            txtReferrer.text = "Referrer : $it"
        }
    }
}
