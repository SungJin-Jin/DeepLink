package io.datalive.myreferrer.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.datalive.myreferrer.R
import kotlinx.android.synthetic.main.activity_install.*

class InstallActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_install)

        txtContent.text = intent.data.query
    }
}
