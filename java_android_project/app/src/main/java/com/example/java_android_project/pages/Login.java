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

public class Login extends AppCompatActivity {
    EditText loginEmail;
    EditText loginPassword;
    Button loginButton;
    TextView textView;
    FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent=new Intent(Login.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginEmail=findViewById(R.id.emaillogin);
        loginPassword=findViewById(R.id.passwordlogin);
        loginButton=findViewById(R.id.loginButton);
        textView=findViewById(R.id.registerNow);
        mAuth=FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressBar2);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login.this, Register.class);
                startActivity(intent);
                finish();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String email,password;
                email=loginEmail.getText().toString();
                password=loginPassword.getText().toString();

                if(TextUtils.isEmpty(email)){
                    progressBar.setVisibility(View.GONE);

                    if(isLanguageTurkish()){ Toast.makeText(Login.this, "Email giriniz.",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(Login.this, "Enter email.",Toast.LENGTH_SHORT).show();
                    }
                    return;
                }
                if(TextUtils.isEmpty(password)){

                    progressBar.setVisibility(View.GONE);
                    if(isLanguageTurkish()){ Toast.makeText(Login.this, "Şifre giriniz.",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(Login.this, "Enter password.",Toast.LENGTH_SHORT).show();
                    }
                    return;
                }

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    if(isLanguageTurkish()){ Toast.makeText(Login.this, "Giris basarılı.",Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(Login.this, "Login succesfull.",Toast.LENGTH_SHORT).show();
                                    }


                                    Intent intent=new Intent(Login.this,MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    // If sign in fails, display a message to the user.


                                    if(isLanguageTurkish()){ Toast.makeText(Login.this, "İşlem başarısız.",Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(Login.this, "Authentication failed.",Toast.LENGTH_SHORT).show();
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