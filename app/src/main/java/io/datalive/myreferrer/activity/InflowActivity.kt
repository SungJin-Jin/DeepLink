package io.datalive.myreferrer.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.datalive.myreferrer.R
import io.datalive.myreferrer.extension.inflowValue
import io.datalive.myreferrer.singletons.Configs.KEY_K1
import io.datalive.myreferrer.singletons.Configs.KEY_K2
import kotlinx.android.synthetic.main.activity_inflow.*

class InflowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inflow)

        txtReferrer.text = "V1 : ${inflowValue(KEY_K1)}, V2 : ${inflowValue(KEY_K2)}"
    }
}
