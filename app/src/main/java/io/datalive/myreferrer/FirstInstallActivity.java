package io.datalive.myreferrer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class FirstInstallActivity extends AppCompatActivity {

    TextView txtReferrer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_install);

        txtReferrer = (TextView) findViewById(R.id.txtReferrer);

        Intent intent = getIntent();
        try {
            String referrer = intent.getStringExtra("referrer");

            txtReferrer.setText("Referrer : " + referrer);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
