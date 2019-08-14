package com.google.myintentapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button btnExplicit;
    Button btnImplicit;
    Button btnImplicit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        btnExplicit = (Button) findViewById(R.id.btn_pindah_activity);
        btnImplicit = (Button) findViewById(R.id.btn_implicit);
        btnImplicit2 = (Button) findViewById(R.id.btn_implicit_2);

        setSupportActionBar(toolbar);

        btn();
    }

    private void btn() {
        btnExplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ExplicitActivity.class);
                i.putExtra(ExplicitActivity.EXTRA_NAME, "Arya Rezza Anantya");
                i.putExtra(ExplicitActivity.EXTRA_AGE, "19");
                startActivity(i);
            }
        });

        btnImplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+6281236067836"));
                startActivity(i);
            }
        });

        btnImplicit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://ayoberalih.com"));
                startActivity(i);
            }
        });
    }
}
