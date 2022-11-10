package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button login;
    boolean mLogin = false;

    private SharedPreferences mSharedPref;
    private final String sharedPrefFile = "com.example.login";
    private final String KEY = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSharedPref = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        mLogin = mSharedPref.getBoolean(KEY, false);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLogin = true;
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                saveLogin();
                startActivity(intent);

            }
        });
    }
    private void saveLogin(){
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putBoolean(KEY, mLogin);
        editor.apply();
    }
}