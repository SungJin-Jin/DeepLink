package io.datalive.myreferrer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_install.*

class InstallActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_install)

        val v1 = intent.data.getQueryParameter("k1")
        val v2 = intent.data.getQueryParameter("k2")

        txtReferrer.text = "V1 : $v1, V2 : $v2"
    }
}
