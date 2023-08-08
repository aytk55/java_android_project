package com.example.loginregister.pages;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginregister.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Locale;

public class Register extends AppCompatActivity {
EditText registerEmail;
EditText registerPassword;
Button registerButton;
ProgressBar progressBar;
FirebaseAuth mAuth;
TextView textView;
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent=new Intent(Register.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerEmail=findViewById(R.id.emailregister);
        registerPassword=findViewById(R.id.passwordregister);
        registerButton=findViewById(R.id.registerButton);
        progressBar=findViewById(R.id.progressBar);

        mAuth=FirebaseAuth.getInstance();
        textView=findViewById(R.id.loginNow);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Register.this, Login.class);
                startActivity(intent);
                finish();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email,password;
                email=registerEmail.getText().toString();
                password=registerPassword.getText().toString();

                if(TextUtils.isEmpty(email)){
                    progressBar.setVisibility(View.GONE);

                    if(isLanguageTurkish()){ Toast.makeText(Register.this, "Email giriniz.",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(Register.this, "Enter email.",Toast.LENGTH_SHORT).show();
                    }
                    return;
                }
                if(TextUtils.isEmpty(password)){

                    progressBar.setVisibility(View.GONE);
                    if(isLanguageTurkish()){ Toast.makeText(Register.this, "Şifre giriniz.",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(Register.this, "Enter password.",Toast.LENGTH_SHORT).show();
                    }
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {

                                    if(isLanguageTurkish()){ Toast.makeText(Register.this, "Hesap oluşturuldu.",Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(Register.this, "Account created.",Toast.LENGTH_SHORT).show();
                                    }
                                    Intent intent=new Intent(Register.this, Login.class);
                                    startActivity(intent);
                                    finish();

                                } else {
                                    // If sign in fails, display a message to the user.

                                    if(isLanguageTurkish()){ Toast.makeText(Register.this, "Hesap oluşturulamadı.",Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(Register.this, "Authentication failed.",Toast.LENGTH_SHORT).show();
                                    }

                                }
                            }
                        });

            }
        });
    }

    private boolean isLanguageTurkish() {
        Locale local=getResources().getConfiguration().getLocales().get(0);
        String currentLanguage=local.getLanguage();
        return currentLanguage.equals("tr");
    }
}