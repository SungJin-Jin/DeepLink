package io.datalive.myreferrer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class InstallActivity extends AppCompatActivity {

    private TextView txtReferrer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_install);

        txtReferrer = (TextView) findViewById(R.id.txtReferrer);

        Intent intent = getIntent();
        Uri uri = intent.getData();
        if(uri != null) {
            String v1 = uri.getQueryParameter("k1");
            String v2 = uri.getQueryParameter("k2");

            txtReferrer.setText("V1 : " + v1 + ", V2 : " + v2);
        }
    }
}
