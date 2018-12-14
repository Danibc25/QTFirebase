package com.example.danielbc.qtfirebase;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button LogBtn = findViewById(R.id.LogBtn);
        Button RegBtn = findViewById(R.id.RegBtn);

        LogBtn.setOnClickListener(this);
        RegBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.RegBtn:
                Intent i = new Intent(this, Registro.class);
                startActivity(i);
                break;
            case R.id.LogBtn:
                Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}