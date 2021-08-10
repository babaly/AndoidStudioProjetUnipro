package com.example.mamadou_baba_ly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText emailLog, passwordLog;
    Button SignIn;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        setContentView(R.layout.activity_login);

        emailLog = (EditText) findViewById(R.id.logemail);
        passwordLog = (EditText) findViewById(R.id.logpassword);
        SignIn = (Button) findViewById(R.id.btnSignIn);
        DB = new DBHelper(this);

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailLog.getText().toString();
                String passw = passwordLog.getText().toString();

                if(email.equals("") || passw.equals("")){
                    Toast.makeText(LoginActivity.this, "Les champs sont obligatoires", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean user = DB.loginCheck(email, passw);
                    if(user == true){
                        Toast.makeText(LoginActivity.this, "connexion réussie", Toast.LENGTH_SHORT).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent homeIntent = new Intent(getApplicationContext(), HomeActivity.class);
                                startActivity(homeIntent);

                                finish();
                            }
                        }, 2000);
                    }else{
                        Toast.makeText(LoginActivity.this, "email ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public void onLoginClick(View view){
        startActivity(new Intent(this, RegisterActivity.class));
        overridePendingTransition(R.anim.slide_in_right, R.anim.stay);
    }
}
