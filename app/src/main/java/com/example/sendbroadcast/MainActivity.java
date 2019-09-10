package com.example.sendbroadcast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText chooseColor;
    private Button choice;
    private TextView first;
    Intent intent = new Intent("android.intent.action.shade");

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String shade = data.getStringExtra("shade");
        first.setText("Your favorite color is " + shade + chooseColor.getText());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        choice = findViewById(R.id.b_color);
        chooseColor = findViewById(R.id.et_color);
        first = findViewById(R.id.tv_first);
        choice.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String s = chooseColor.getText().toString();

        intent.putExtra("color", s);
        startActivityForResult(intent, 1);


    }
}
