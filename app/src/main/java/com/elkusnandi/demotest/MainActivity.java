package com.elkusnandi.demotest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_USERNAME = "username";

    private EditText editText;
    private Button logInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.et_username);
        logInButton = findViewById(R.id.bt_loggin);
        logInButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.bt_loggin) {
            String userName = editText.getText().toString();
            if(userName.isEmpty()) {
                Toast.makeText(this, "Username is empty", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(this, HomeActivity.class);
                intent.putExtra(EXTRA_USERNAME, userName);
                startActivity(intent);
            }
        }
    }
}
