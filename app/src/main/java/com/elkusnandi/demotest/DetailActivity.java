package com.elkusnandi.demotest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_EMAIL = "extra_email";
    public static final String EXTRA_ADDRESS = "extra_address";
    public static final String EXTRA_PHONE = "extra_phone";
    public static final String EXTRA_WEBSITE = "extra_website";

    private TextView textViewName;
    private TextView textViewEmail;
    private TextView textViewAddress;
    private TextView textViewPhone;
    private TextView textViewWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // set details
        textViewName = findViewById(R.id.tv_name);
        textViewName.setText(getString(R.string.text_user_name, getIntent().getStringExtra(EXTRA_NAME)));
        textViewEmail = findViewById(R.id.tv_email);
        textViewEmail.setText(getString(R.string.text_user_email, getIntent().getStringExtra(EXTRA_EMAIL)));
        textViewAddress = findViewById(R.id.tv_address);
        textViewAddress.setText(getString(R.string.text_user_address, getIntent().getStringExtra(EXTRA_ADDRESS)));
        textViewPhone = findViewById(R.id.tv_phone);
        textViewPhone.setText(getString(R.string.text_user_phone, getIntent().getStringExtra(EXTRA_PHONE)));
        textViewWebsite = findViewById(R.id.tv_website);
        textViewWebsite.setText(getString(R.string.text_user_website, getIntent().getStringExtra(EXTRA_WEBSITE)));
    }

}
