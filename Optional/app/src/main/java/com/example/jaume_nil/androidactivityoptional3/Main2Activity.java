package com.example.jaume_nil.androidactivityoptional3;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        text = (TextView) findViewById(R.id.text);

        Intent intent = getIntent();
        Uri data = intent.getData();
        if (data != null) {
            String stringUri = data.toString();
            text.setText(stringUri);
        }
    }
}
