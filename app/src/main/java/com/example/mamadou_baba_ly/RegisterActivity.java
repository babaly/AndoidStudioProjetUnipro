package com.example.mamadou_baba_ly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText name, username, email, password, NewPassword;
    Button SignUp;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        changeStatusBarColor();

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        NewPassword = (EditText) findViewById(R.id.repassword);
        SignUp = (Button) findViewById(R.id.btnSignUp);
        DB = new DBHelper(this);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String last = name.getText().toString();
                String first = username.getText().toString();
                String mail = email.getText().toString();
                String pass = password.getText().toString();
                String passNew = NewPassword.getText().toString();

                if(last.equals("") || first.equals("") || mail.equals("") || pass.equals("") || passNew.equals("")){
                    Toast.makeText(RegisterActivity.this, "Tous les champs sont requises", Toast.LENGTH_SHORT).show();
                }else{
                    if(pass.equals(passNew)){
                        Boolean user = DB.checkEmail(mail);
                        if(user == false){
                            Boolean insert = DB.insertData(last, first, mail, pass);
                            if(insert == true){
                                Toast.makeText(RegisterActivity.this, "Inscription réussie avec succès", Toast.LENGTH_SHORT).show();
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent loginIntent = new Intent(getApplicationContext(), LoginActivity.class);
                                        startActivity(loginIntent);

                                        finish();
                                    }
                                }, 2000);
                            }else{
                                Toast.makeText(RegisterActivity.this, "Erreur lors de l'inscription", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(RegisterActivity.this, "Cet email existe déjà", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(RegisterActivity.this, "Vos mot de passe ne correspondent pas !", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public void changeStatusBarColor(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.register_bk_color));
        }
    }

    public void onLoginClick(View view){
        startActivity(new Intent(this, LoginActivity.class));
        overridePendingTransition(R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
}
