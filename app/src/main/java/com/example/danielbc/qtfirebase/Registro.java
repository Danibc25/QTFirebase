package com.example.danielbc.qtfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Registro extends AppCompatActivity implements View.OnClickListener {

    private EditText Usuario, Password, PasswordCop;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Usuario = findViewById(R.id.UsuEt);
        Password = findViewById(R.id.PassEt);
        PasswordCop = findViewById(R.id.Pass2Et);
        
        mAuth = FirebaseAuth.getInstance();


        Button CancelBtn = findViewById(R.id.CancelBtn);
        Button SendBtn = findViewById(R.id.SendBtn);

        CancelBtn.setOnClickListener(this);
        SendBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.CancelBtn:
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                break;

            case R.id.SendBtn:
                Comprobar();
                break;
        }

    }

    public void Comprobar() {

        String Usu = Usuario.getText().toString();
        String Ps1 = Password.getText().toString();
        String Ps2 = PasswordCop.getText().toString();

        if (Usu.compareTo("") != 0
                && Ps1.compareTo("") != 0
                && Ps2.compareTo("") != 0) {

            if (Ps1.compareTo(Ps2) == 0) {

                
                registrar(Usu, Ps1);
                Toast.makeText(this, "Todo de ptm", Toast.LENGTH_SHORT).show();



            } else {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Tienen que estar todos los campos completados", Toast.LENGTH_SHORT).show();
        }
    }


    public void registrar(String email, String password) {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(Registro.this, "Authentication successful.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(Registro.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }
}


